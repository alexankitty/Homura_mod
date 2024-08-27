/*    */ package powers;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
/*    */ import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import java.util.ArrayList;
/*    */ import patches.Patch;
/*    */ 
/*    */ public class FalseTownPower extends AbstractPower {
/* 17 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("FalseTownPower"); public static final String POWER_ID = "FalseTownPower";
/* 18 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS; boolean isUpgrade;
/*    */   
/*    */   public FalseTownPower(AbstractCreature owner, boolean isUpgrade, int Amount) {
/* 21 */     this.name = powerStrings.NAME;
/* 22 */     this.ID = "FalseTownPower";
/* 23 */     this.owner = owner;
/* 24 */     this.img = new Texture("img/powers/FalseTownPower32.png");
/* 25 */     this.type = AbstractPower.PowerType.BUFF;
/* 26 */     this.isUpgrade = isUpgrade;
/* 27 */     this.amount = Amount;
/* 28 */     updateDescription();
/*    */   }
/*    */   
/*    */   public void stackPower(int stackAmount) {
/* 32 */     this.fontScale = 8.0F;
/* 33 */     this.amount += stackAmount;
/* 34 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public void atStartOfTurn() {
/* 39 */     ArrayList<AbstractCard> cl = Patch.getServant(this.amount);
/* 40 */     for (AbstractCard c : cl) {
/* 41 */       addToBot((AbstractGameAction)new MakeTempCardInDrawPileAction(c, 1, true, true));
/* 42 */       AbstractCard curse = AbstractDungeon.returnRandomCurse().makeCopy();
/* 43 */       addToBot((AbstractGameAction)new MakeTempCardInDiscardAction(curse, 1));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 54 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1] + this.amount + DESCRIPTIONS[2];
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/FalseTownPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */