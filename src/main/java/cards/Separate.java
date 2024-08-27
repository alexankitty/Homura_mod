/*    */ package cards;
/*    */ import EgoMod.AbstractCardEnum;
import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.StrengthPower;
/*    */ import patches.Patch;
/*    */ 
/*    */ public class Separate extends CustomCard {
/* 15 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Separate"); public static final String ID = "Separate";
/* 16 */   public static final String NAME = cardStrings.NAME;
/* 17 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   
/*    */   private static final int COST = 1;
/*    */   public static final String IMG_PATH = "img/cards/Separate_skill.png";
/*    */   
/*    */   public Separate() {
/* 23 */     super("Separate", NAME, "img/cards/Separate_skill.png", 1, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.ENEMY);
/* 24 */     this.baseMagicNumber = 0;
/* 25 */     this.magicNumber = this.baseMagicNumber;
/* 26 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 31 */     this.magicNumber = Patch.countCurse();
/* 32 */     if (this.magicNumber > 0) {
/* 33 */       addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new StrengthPower((AbstractCreature)m, -this.magicNumber), -this.magicNumber));
/* 34 */       if (!m.hasPower("Artifact"))
/* 35 */         addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new StrengthPower((AbstractCreature)p, this.magicNumber), this.magicNumber)); 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void calculateCardDamage(AbstractMonster mo) {
/* 40 */     this.baseMagicNumber = Patch.countCurse();
/* 41 */     super.calculateCardDamage(mo);
/*    */   }
/*    */   public void applyPowers() {
/* 44 */     this.baseMagicNumber = Patch.countCurse();
/* 45 */     super.applyPowers();
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 49 */     return (AbstractCard)new Separate();
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 54 */     if (!this.upgraded) {
/* 55 */       upgradeName();
/* 56 */       upgradeBaseCost(0);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Separate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */