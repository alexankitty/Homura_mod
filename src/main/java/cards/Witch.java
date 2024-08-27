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
import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
/*    */ import patches.Patch;
/*    */ 
/*    */ public class Witch extends CustomCard {
/* 15 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Witch"); public static final String ID = "Witch";
/* 16 */   public static final String NAME = cardStrings.NAME;
/* 17 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   
/*    */   private static final int COST = 1;
/*    */   public static final String IMG_PATH = "img/cards/Witch_power.png";
/*    */   
/*    */   public Witch() {
/* 23 */     super("Witch", NAME, "img/cards/Witch_power.png", 1, DESCRIPTION, AbstractCard.CardType.POWER, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.NONE);
/* 24 */     this.baseMagicNumber = 0;
/* 25 */     this.magicNumber = this.baseMagicNumber;
/* 26 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 31 */     this.magicNumber = Patch.countCurse();
/* 32 */     if (this.magicNumber > 0)
/* 33 */       addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new StrengthPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */   
/*    */   public void calculateCardDamage(AbstractMonster mo) {
/* 37 */     this.baseMagicNumber = Patch.countCurse();
/* 38 */     super.calculateCardDamage(mo);
/*    */   }
/*    */   public void applyPowers() {
/* 41 */     this.baseMagicNumber = Patch.countCurse();
/* 42 */     super.applyPowers();
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 46 */     return (AbstractCard)new Witch();
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 51 */     if (!this.upgraded) {
/* 52 */       upgradeName();
/* 53 */       upgradeBaseCost(0);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Witch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */