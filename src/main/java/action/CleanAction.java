/*    */ package action;
/*    */ 
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;
/*    */ 
/*    */ public class CleanAction
/*    */   extends AbstractGameAction
/*    */ {
/*    */   private final DamageInfo info;
/*    */   private final AbstractCard theCard;
/*    */   
/*    */   public CleanAction(AbstractCreature target, DamageInfo info, AbstractCard theCard) {
/* 18 */     this.info = info;
/* 19 */     setValues(target, info);
/* 20 */     this.actionType = AbstractGameAction.ActionType.DAMAGE;
/* 21 */     this.duration = 0.1F;
/* 22 */     this.theCard = theCard;
/*    */   }
/*    */   
/*    */   public void update() {
/* 26 */     if (this.duration == 0.1F && this.target != null) {
/* 27 */       AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.target.hb.cX, this.target.hb.cY, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
/* 28 */       this.target.damage(this.info);
/* 29 */       if (this.target.isDying || this.target.currentHealth <= 0) {
/* 30 */         AbstractCard c = this.theCard;
/* 31 */         if (c.upgraded) {
/* 32 */           c.upgrade();
/*    */         }
/* 34 */         c.setCostForTurn(0);
/* 35 */         addToBot((AbstractGameAction)new MakeTempCardInHandAction(c, 1));
/*    */       } 
/*    */       
/* 38 */       if ((AbstractDungeon.getCurrRoom()).monsters.areMonstersBasicallyDead()) {
/* 39 */         AbstractDungeon.actionManager.clearPostCombatActions();
/*    */       }
/*    */     } 
/* 42 */     this.isDone = true;
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/action/CleanAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */