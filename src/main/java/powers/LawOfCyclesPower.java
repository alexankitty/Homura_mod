/*    */ package powers;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.tempCards.Miracle;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class LawOfCyclesPower extends AbstractPower {
/* 16 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("LawOfCyclesPower"); public static final String POWER_ID = "LawOfCyclesPower";
/* 17 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   public LawOfCyclesPower(AbstractCreature owner, int amount) {
/* 19 */     this.name = powerStrings.NAME;
/* 20 */     this.ID = "LawOfCyclesPower";
/* 21 */     this.owner = owner;
/* 22 */     this.img = new Texture("img/powers/LawOfCyclesPower32.png");
/* 23 */     this.type = AbstractPower.PowerType.BUFF;
/* 24 */     this.amount = amount;
/* 25 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public void onCardDraw(AbstractCard card) {
/* 30 */     if (card.type == AbstractCard.CardType.CURSE && !AbstractDungeon.player.hasRelic("SoulGem_Demon")) {
/* 31 */       flash();
/* 32 */       AbstractPlayer p = AbstractDungeon.player;
/* 33 */       p.hand.moveToExhaustPile(card);
/* 34 */       addToBot((AbstractGameAction)new MakeTempCardInHandAction((AbstractCard)new Miracle(), this.amount));
/*    */     } 
/*    */   }
/*    */   public void updateDescription() {
/* 38 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/LawOfCyclesPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */