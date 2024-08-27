/*    */ package powers;
/*    */ import cards.IED;
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class BombMakingPower extends AbstractPower {
/* 13 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("BombMakingPower"); public static final String POWER_ID = "BombMakingPower";
/* 14 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   
/*    */   public BombMakingPower(AbstractCreature owner, int amount) {
/* 17 */     this.name = powerStrings.NAME;
/* 18 */     this.ID = "BombMakingPower";
/* 19 */     this.owner = owner;
/* 20 */     this.img = new Texture("img/powers/BombMakingPower32.png");
/* 21 */     this.type = AbstractPower.PowerType.BUFF;
/* 22 */     this.amount = amount;
/* 23 */     updateDescription();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void atStartOfTurn() {
/* 29 */     AbstractCard c = (new IED()).makeCopy();
/* 30 */     addToBot((AbstractGameAction)new MakeTempCardInHandAction(c, this.amount));
/*    */   }
/*    */   public void updateDescription() {
/* 33 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/BombMakingPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */