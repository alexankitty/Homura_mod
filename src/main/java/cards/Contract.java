/*    */ package cards;
/*    */ 
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
/*    */ import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.purple.Wish;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class Contract extends CustomCard {
/*    */   public static final String ID = "Contract";
/* 18 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Contract");
/* 19 */   public static final String NAME = cardStrings.NAME;
/* 20 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   
/*    */   private static final int COST = 1;
/*    */   public static final String IMG_PATH = "img/cards/Contract_skill.png";
/*    */   
/*    */   public Contract() {
/* 26 */     super("Contract", NAME, "img/cards/Contract_skill.png", 1, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.SELF);
/* 27 */     this.cardsToPreview = (AbstractCard)new Wish();
/* 28 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 33 */     AbstractCard c = (new Wish()).makeCopy();
/* 34 */     if (this.upgraded) {
/* 35 */       c.upgrade();
/*    */     }
/* 37 */     c.setCostForTurn(0);
/* 38 */     addToBot((AbstractGameAction)new MakeTempCardInHandAction(c, 1));
/*    */     
/* 40 */     c = AbstractDungeon.returnRandomCurse().makeCopy();
/* 41 */     addToBot((AbstractGameAction)new MakeTempCardInDiscardAction(c, 1));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 48 */     return (AbstractCard)new Contract();
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 53 */     if (!this.upgraded) {
/* 54 */       upgradeName();
/* 55 */       this.cardsToPreview.upgrade();
/* 56 */       this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
/* 57 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Contract.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */