/*    */ package powers;
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.utility.DrawPileToHandAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class StaminaPower extends AbstractPower {
/* 12 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("StaminaPower"); public static final String POWER_ID = "StaminaPower";
/* 13 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   public StaminaPower(AbstractCreature owner, int amount) {
/* 15 */     this.name = powerStrings.NAME;
/* 16 */     this.ID = "StaminaPower";
/* 17 */     this.owner = owner;
/* 18 */     this.amount = amount;
/* 19 */     this.img = new Texture("img/powers/StaminaPower32.png");
/* 20 */     this.type = AbstractPower.PowerType.BUFF;
/* 21 */     updateDescription();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void onAfterCardPlayed(AbstractCard usedCard) {
/* 27 */     if (usedCard.type == AbstractCard.CardType.ATTACK) {
/* 28 */       addToBot((AbstractGameAction)new DrawPileToHandAction(this.amount, AbstractCard.CardType.SKILL));
/*    */     }
/* 30 */     if (usedCard.type == AbstractCard.CardType.SKILL) {
/* 31 */       addToBot((AbstractGameAction)new DrawPileToHandAction(this.amount, AbstractCard.CardType.ATTACK));
/*    */     }
/* 33 */     super.onAfterCardPlayed(usedCard);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 39 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1] + this.amount + DESCRIPTIONS[2];
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/StaminaPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */