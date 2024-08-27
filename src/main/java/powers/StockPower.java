/*    */ package powers;
/*    */ import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import patches.Patch;
/*    */ 
/*    */ public class StockPower extends AbstractPower {
/* 13 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("StockPower"); public static final String POWER_ID = "StockPower";
/* 14 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   
/*    */   public StockPower(AbstractCreature owner, int amount) {
/* 17 */     this.name = powerStrings.NAME;
/* 18 */     this.ID = "StockPower";
/* 19 */     this.owner = owner;
/* 20 */     this.img = new Texture("img/powers/StockPower32.png");
/* 21 */     this.type = AbstractPower.PowerType.BUFF;
/* 22 */     this.amount = amount;
/* 23 */     updateDescription();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void atStartOfTurn() {
/* 29 */     flash();
/* 30 */     AbstractCard[] ArmsGroup = Patch.getArmsCard();
/*    */     
/* 32 */     for (int i = 0; i < this.amount; i++) {
/* 33 */       AbstractCard c = ArmsGroup[AbstractDungeon.cardRandomRng.random(ArmsGroup.length - 1)];
/* 34 */       addToBot((AbstractGameAction)new MakeTempCardInHandAction(c, 1));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 41 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/StockPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */