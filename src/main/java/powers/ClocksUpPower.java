/*    */ package powers;
/*    */ 
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
/*    */ import com.megacrit.cardcrawl.actions.utility.UseCardAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.purple.Vault;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class ClocksUpPower extends AbstractPower {
/* 14 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("ClocksUpPower"); public static final String POWER_ID = "ClocksUpPower";
/* 15 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS; private int count;
/*    */   
/*    */   public ClocksUpPower(AbstractCreature owner, int count) {
/* 18 */     this.name = powerStrings.NAME;
/* 19 */     this.ID = "ClocksUpPower";
/* 20 */     this.owner = owner;
/*    */     
/* 22 */     loadRegion("time");
/* 23 */     this.type = AbstractPower.PowerType.BUFF;
/* 24 */     this.amount = 0;
/* 25 */     this.count = count;
/* 26 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public void stackPower(int stackAmount) {
/* 31 */     this.fontScale = 8.0F;
/* 32 */     this.count++;
/* 33 */     updateDescription();
/*    */   }
/*    */   
/*    */   public void onUseCard(AbstractCard card, UseCardAction action) {
/* 37 */     this.amount++;
/* 38 */     if (this.amount == 12) {
/* 39 */       flash();
/* 40 */       AbstractCard c = (new Vault()).makeCopy();
/* 41 */       c.upgrade();
/* 42 */       addToBot((AbstractGameAction)new MakeTempCardInHandAction(c, this.count));
/* 43 */       this.amount = 0;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void updateDescription() {
/* 48 */     this.description = DESCRIPTIONS[0] + this.count + DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/ClocksUpPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */