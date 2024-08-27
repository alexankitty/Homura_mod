/*    */ package action;
/*    */ 
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.Settings;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
/*    */ import patches.Patch;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GunsWorkBetterThanMagicAction
/*    */   extends AbstractGameAction
/*    */ {
/*    */   private final boolean freeToPlayOnce;
/*    */   private final boolean upgraded;
/*    */   private final AbstractPlayer p;
/*    */   private final int energyOnUse;
/*    */   
/*    */   public GunsWorkBetterThanMagicAction(AbstractPlayer p, boolean upgraded, boolean freeToPlayOnce, int energyOnUse) {
/* 23 */     this.p = p;
/* 24 */     this.upgraded = upgraded;
/* 25 */     this.freeToPlayOnce = freeToPlayOnce;
/* 26 */     this.duration = Settings.ACTION_DUR_XFAST;
/* 27 */     this.actionType = AbstractGameAction.ActionType.SPECIAL;
/* 28 */     this.energyOnUse = energyOnUse;
/*    */   }
/*    */   
/*    */   public void update() {
/* 32 */     int effect = EnergyPanel.totalCount;
/* 33 */     if (this.energyOnUse != -1) {
/* 34 */       effect = this.energyOnUse;
/*    */     }
/*    */     
/* 37 */     if (this.p.hasRelic("Chemical X")) {
/* 38 */       effect += 2;
/* 39 */       this.p.getRelic("Chemical X").flash();
/*    */     } 
/* 41 */     AbstractCard[] ArmsGroup = Patch.getArmsCard();
/* 42 */     if (effect > 0) {
/* 43 */       for (int i = 0; i < effect; i++) {
/* 44 */         AbstractCard c = ArmsGroup[AbstractDungeon.cardRandomRng.random(ArmsGroup.length - 1)];
/*    */         
/* 46 */         if (this.upgraded) {
/* 47 */           c.upgrade();
/*    */         }
/* 49 */         c.setCostForTurn(0);
/* 50 */         addToBot((AbstractGameAction)new MakeTempCardInHandAction(c, 1));
/*    */       } 
/*    */       
/* 53 */       if (!this.freeToPlayOnce) {
/* 54 */         this.p.energy.use(EnergyPanel.totalCount);
/*    */       }
/*    */     } 
/*    */     
/* 58 */     this.isDone = true;
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/action/GunsWorkBetterThanMagicAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */