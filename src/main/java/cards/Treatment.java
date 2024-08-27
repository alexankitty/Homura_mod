/*    */ package cards;
/*    */ 
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import action.TreatmentAction;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class Treatment extends CustomCard {
/* 14 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Treatment"); public static final String ID = "Treatment";
/* 15 */   public static final String NAME = cardStrings.NAME;
/* 16 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   
/*    */   private static final int COST = 0;
/*    */   public static final String IMG_PATH = "img/cards/Treatment_skill.png";
/*    */   
/*    */   public Treatment() {
/* 22 */     super("Treatment", NAME, "img/cards/Treatment_skill.png", 0, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.SELF);
/* 23 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 28 */     addToTop((AbstractGameAction)new TreatmentAction());
/*    */   }
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 33 */     return (AbstractCard)new Treatment();
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 38 */     if (!this.upgraded) {
/* 39 */       upgradeName();
/* 40 */       this.selfRetain = true;
/* 41 */       this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
/* 42 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Treatment.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */