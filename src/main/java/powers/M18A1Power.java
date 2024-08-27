/*    */ package powers;
/*    */ 
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class M18A1Power extends AbstractPower {
/*    */   public static final String POWER_ID = "M18A1Power";
/* 15 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("M18A1Power");
/* 16 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   
/*    */   public M18A1Power(AbstractCreature owner, int amount) {
/* 19 */     this.name = powerStrings.NAME;
/* 20 */     this.ID = "M18A1Power";
/* 21 */     this.owner = owner;
/* 22 */     loadRegion("flameBarrier");
/* 23 */     this.type = AbstractPower.PowerType.BUFF;
/* 24 */     this.amount = amount;
/* 25 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public int onAttacked(DamageInfo info, int damageAmount) {
/* 30 */     if (info.owner != null && info.type != DamageInfo.DamageType.THORNS && info.type != DamageInfo.DamageType.HP_LOSS && info.owner != this.owner) {
/* 31 */       flash();
/* 32 */       if (this.amount <= 0) {
/* 33 */         AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new RemoveSpecificPowerAction(this.owner, this.owner, "M18A1Power"));
/*    */       } else {
/* 35 */         this.amount--;
/* 36 */         addToTop((AbstractGameAction)new DamageAction(info.owner, new DamageInfo(this.owner, info.output, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.FIRE));
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 41 */     return damageAmount;
/*    */   }
/*    */   
/*    */   public void updateDescription() {
/* 45 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/M18A1Power.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */