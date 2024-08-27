/*    */ package cards;
/*    */ 
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class No15 extends CustomCard {
/* 14 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("No15"); public static final String ID = "No15";
/* 15 */   public static final String NAME = cardStrings.NAME;
/* 16 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/cards/No15_skill.png";
/*    */   private static final int COST = -2;
/*    */   
/*    */   public No15() {
/* 21 */     super("No15", NAME, "img/cards/No15_skill.png", -2, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.SELF);
/* 22 */     this.baseMagicNumber = 1;
/* 23 */     this.magicNumber = this.baseMagicNumber;
/*    */   }
/*    */   
/*    */   public void triggerWhenDrawn() {
/* 27 */     addToBot((AbstractGameAction)new GainEnergyAction(this.magicNumber));
/*    */   }
/*    */   
/*    */   public void triggerOnManualDiscard() {
/* 31 */     addToBot((AbstractGameAction)new GainEnergyAction(this.magicNumber));
/*    */   }
/*    */   
/*    */   public boolean canUse(AbstractPlayer p, AbstractMonster m) {
/* 35 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {}
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 44 */     return (AbstractCard)new No15();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 48 */     if (!this.upgraded) {
/* 49 */       upgradeName();
/* 50 */       this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
/* 51 */       initializeDescription();
/* 52 */       upgradeMagicNumber(1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/No15.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */