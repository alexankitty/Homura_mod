/*    */ package cards;
/*    */ 
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DrawCardAction;
/*    */ import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import patches.Patch;
/*    */ 
/*    */ public class Maze extends CustomCard {
/* 16 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Maze"); public static final String ID = "Maze";
/* 17 */   public static final String NAME = cardStrings.NAME;
/* 18 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   private static final int COST = 0;
/*    */   public static final String IMG_PATH = "img/cards/Maze_skill.png";
/*    */   
/*    */   public Maze() {
/* 23 */     super("Maze", NAME, "img/cards/Maze_skill.png", 0, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.SELF);
/* 24 */     this.baseMagicNumber = 0;
/* 25 */     this.magicNumber = this.baseMagicNumber;
/* 26 */     this.exhaust = true;
/* 27 */     this.cardsToPreview = (AbstractCard)new Despair();
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 32 */     this.magicNumber = Patch.countSL();
/* 33 */     addToBot((AbstractGameAction)new DrawCardAction(this.magicNumber));
/* 34 */     AbstractCard c = (new Despair()).makeCopy();
/* 35 */     addToBot((AbstractGameAction)new MakeTempCardInDiscardAction(c, 1));
/*    */   }
/*    */   public void calculateCardDamage(AbstractMonster mo) {
/* 38 */     this.baseMagicNumber = Patch.countSL();
/* 39 */     super.calculateCardDamage(mo);
/*    */   }
/*    */   public void applyPowers() {
/* 42 */     this.baseMagicNumber = Patch.countSL();
/* 43 */     super.applyPowers();
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 47 */     return (AbstractCard)new Maze();
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 52 */     if (!this.upgraded) {
/* 53 */       upgradeName();
/* 54 */       this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
/* 55 */       initializeDescription();
/* 56 */       this.exhaust = false;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Maze.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */