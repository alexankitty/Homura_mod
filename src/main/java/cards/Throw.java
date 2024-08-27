/*    */ package cards;
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DiscardAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DrawCardAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class Throw extends CustomCard {
/* 15 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Throw"); public static final String ID = "Throw";
/* 16 */   public static final String NAME = cardStrings.NAME;
/* 17 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   
/*    */   private static final int COST = 0;
/*    */   public static final String IMG_PATH = "img/cards/Throw_skill.png";
/*    */   
/*    */   public Throw() {
/* 23 */     super("Throw", NAME, "img/cards/Throw_skill.png", 0, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.BASIC, AbstractCard.CardTarget.SELF);
/* 24 */     this.baseMagicNumber = 1;
/* 25 */     this.selfRetain = true;
/* 26 */     this.magicNumber = this.baseMagicNumber;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 31 */     addToBot((AbstractGameAction)new DiscardAction((AbstractCreature)p, (AbstractCreature)p, this.magicNumber, false));
/* 32 */     addToBot((AbstractGameAction)new DrawCardAction(this.magicNumber));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 38 */     return (AbstractCard)new Throw();
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 43 */     if (!this.upgraded) {
/* 44 */       upgradeName();
/* 45 */       upgradeMagicNumber(1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Throw.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */