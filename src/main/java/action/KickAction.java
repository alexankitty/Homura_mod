/*    */ package action;
/*    */ 
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.animations.VFXAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.utility.WaitAction;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.Settings;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.GainStrengthPower;
/*    */ import com.megacrit.cardcrawl.powers.StrengthPower;
/*    */ import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
/*    */ import com.megacrit.cardcrawl.vfx.WallopEffect;
/*    */ import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;
/*    */ 
/*    */ public class KickAction
/*    */   extends AbstractGameAction {
/*    */   private DamageInfo info;
/*    */   
/*    */   public KickAction(AbstractCreature target, DamageInfo info) {
/* 23 */     this.info = info;
/* 24 */     setValues(target, info);
/* 25 */     this.actionType = AbstractGameAction.ActionType.DAMAGE;
/* 26 */     this.startDuration = Settings.ACTION_DUR_FAST;
/* 27 */     this.duration = this.startDuration;
/*    */   }
/*    */   
/*    */   public void update() {
/* 31 */     if (shouldCancelAction()) {
/* 32 */       this.isDone = true;
/*    */     } else {
/* 34 */       tickDuration();
/* 35 */       if (this.isDone) {
/* 36 */         AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.target.hb.cX, this.target.hb.cY, AbstractGameAction.AttackEffect.BLUNT_HEAVY, false));
/* 37 */         this.target.damage(this.info);
/* 38 */         if (this.target.lastDamageTaken > 0) {
/*    */           
/* 40 */           addToBot((AbstractGameAction)new ApplyPowerAction(this.target, this.source, (AbstractPower)new StrengthPower(this.target, -this.target.lastDamageTaken), -this.target.lastDamageTaken));
/* 41 */           if (!this.target.hasPower("Artifact")) {
/* 42 */             addToBot((AbstractGameAction)new ApplyPowerAction(this.target, this.source, (AbstractPower)new GainStrengthPower(this.target, this.target.lastDamageTaken), this.target.lastDamageTaken, true, AbstractGameAction.AttackEffect.NONE));
/*    */           }
/*    */           
/* 45 */           if (this.target.hb != null) {
/* 46 */             addToTop((AbstractGameAction)new VFXAction((AbstractGameEffect)new WallopEffect(this.target.lastDamageTaken, this.target.hb.cX, this.target.hb.cY)));
/*    */           }
/*    */         } 
/*    */         
/* 50 */         if ((AbstractDungeon.getCurrRoom()).monsters.areMonstersBasicallyDead()) {
/* 51 */           AbstractDungeon.actionManager.clearPostCombatActions();
/*    */         } else {
/* 53 */           addToTop((AbstractGameAction)new WaitAction(0.1F));
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/action/KickAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */