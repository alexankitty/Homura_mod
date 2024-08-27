/*    */ package cards;
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.ConstrictedPower;
/*    */ import patches.Patch;
import powers.TwiningPower;

/*    */
/*    */ public class Twining extends CustomCard {
/* 17 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Twining"); public static final String ID = "Twining";
/* 18 */   public static final String NAME = cardStrings.NAME;
/* 19 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   
/*    */   private static final int COST = 1;
/*    */   public static final String IMG_PATH = "img/cards/Twining_power.png";
/*    */   
/*    */   public Twining() {
/* 25 */     super("Twining", NAME, "img/cards/Twining_power.png", 1, DESCRIPTION, AbstractCard.CardType.POWER, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.SELF);
/* 26 */     this.baseMagicNumber = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 31 */     this.magicNumber = Patch.countSL();
/* 32 */     if (this.magicNumber > 0) {
/* 33 */       addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new ConstrictedPower((AbstractCreature)p, (AbstractCreature)p, this.magicNumber)));
/*    */     }
/* 35 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new TwiningPower((AbstractCreature)p, 1)));
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
/* 47 */     return (AbstractCard)new Twining();
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 52 */     if (!this.upgraded) {
/* 53 */       upgradeName();
/* 54 */       upgradeBaseCost(0);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Twining.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */