/*    */ package cards;
/*    */ 
/*    */ import EgoMod.HomuraMod;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.LoseHPAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.CardQueueItem;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import patches.Patch;
/*    */ 
/*    */ public class Despair extends CustomCard {
/* 18 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Despair"); public static final String ID = "Despair";
/* 19 */   public static final String NAME = cardStrings.NAME;
/* 20 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   
/*    */   private static final int COST = -2;
/*    */   
/*    */   public static final String IMG_PATH = "img/cards/Despair.png";
/*    */   
/*    */   public Despair() {
/* 27 */     super("Despair", NAME, "img/cards/Despair.png", -2, DESCRIPTION, AbstractCard.CardType.CURSE, AbstractCard.CardColor.CURSE, AbstractCard.CardRarity.CURSE, AbstractCard.CardTarget.NONE);
/* 28 */     this.baseMagicNumber = 0;
/* 29 */     this.magicNumber = this.baseMagicNumber;
/*    */   }
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 33 */     if (this.dontTriggerOnUseCard && AbstractDungeon.player.masterDeck.findCardById("CauseAndEffect") != null) {
/* 34 */       addToTop((AbstractGameAction)new LoseHPAction((AbstractCreature)AbstractDungeon.player, (AbstractCreature)AbstractDungeon.player, this.magicNumber, AbstractGameAction.AttackEffect.FIRE));
/*    */     }
/*    */   }
/*    */   
/*    */   public void calculateCardDamage(AbstractMonster m) {
/* 39 */     this.baseMagicNumber = HomuraMod.getSaveLoadCount();
/* 40 */     this.magicNumber = this.baseMagicNumber;
/*    */   }
/*    */   public void applyPowers() {
/* 43 */     this.baseMagicNumber = HomuraMod.getSaveLoadCount();
/* 44 */     this.magicNumber = this.baseMagicNumber;
/*    */   }
/*    */   public void triggerOnEndOfTurnForPlayingCard() {
/* 47 */     this.dontTriggerOnUseCard = true;
/* 48 */     this.magicNumber = this.baseMagicNumber = Patch.countSL();
/* 49 */     AbstractDungeon.actionManager.cardQueue.add(new CardQueueItem((AbstractCard)this, true));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 56 */     return (AbstractCard)new Despair();
/*    */   }
/*    */   
/*    */   public void upgrade() {}
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Despair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */