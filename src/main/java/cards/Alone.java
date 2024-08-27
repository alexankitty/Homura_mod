/*    */ package cards;
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainBlockAction;
/*    */ import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import patches.Patch;
/*    */ 
/*    */ public class Alone extends CustomCard {
/* 16 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Alone"); public static final String ID = "Alone";
/* 17 */   public static final String NAME = cardStrings.NAME;
/* 18 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   
/*    */   private static final int COST = 2;
/*    */   public static final String IMG_PATH = "img/cards/Alone_skill.png";
/*    */   
/*    */   public Alone() {
/* 24 */     super("Alone", NAME, "img/cards/Alone_skill.png", 2, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.SELF);
/* 25 */     this.baseMagicNumber = 1;
/* 26 */     this.magicNumber = this.baseMagicNumber;
/* 27 */     this.baseBlock = 0;
/* 28 */     this.cardsToPreview = (AbstractCard)new Despair();
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 33 */     addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
/* 34 */     AbstractCard c = (new Despair()).makeCopy();
/* 35 */     addToBot((AbstractGameAction)new MakeTempCardInDiscardAction(c, 1));
/*    */   }
/*    */   
/*    */   public void calculateCardDamage(AbstractMonster m) {
/* 39 */     this.baseBlock = Patch.countHighlander();
/* 40 */     if (this.upgraded) {
/* 41 */       this.baseBlock += Patch.countCurse();
/*    */     }
/* 43 */     super.calculateCardDamage(m);
/*    */   }
/*    */   
/*    */   public void applyPowers() {
/* 47 */     this.baseBlock = Patch.countHighlander();
/* 48 */     if (this.upgraded) {
/* 49 */       this.baseBlock += Patch.countCurse();
/*    */     }
/* 51 */     super.applyPowers();
/*    */   }
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 56 */     return (AbstractCard)new Alone();
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 61 */     if (!this.upgraded) {
/* 62 */       upgradeName();
/* 63 */       this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
/* 64 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Alone.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */