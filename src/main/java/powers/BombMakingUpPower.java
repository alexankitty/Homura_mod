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
/*    */ public class BombMakingUpPower extends AbstractPower {
/* 13 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("BombMakingUpPower"); public static final String POWER_ID = "BombMakingUpPower";
/* 14 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   public BombMakingUpPower(AbstractCreature owner, int amount) {
/* 16 */     this.name = powerStrings.NAME;
/* 17 */     this.ID = "BombMakingUpPower";
/* 18 */     this.owner = owner;
/* 19 */     this.img = new Texture("img/powers/BombMakingPower32.png");
/* 20 */     this.type = AbstractPower.PowerType.BUFF;
/* 21 */     this.amount = amount;
/* 22 */     updateDescription();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void atStartOfTurn() {
/* 28 */     AbstractCard c = (new IED()).makeCopy();
/* 29 */     c.upgrade();
/* 30 */     addToBot((AbstractGameAction)new MakeTempCardInHandAction(c, this.amount));
/*    */   }
/*    */   public void updateDescription() {
/* 33 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/BombMakingUpPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */