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
/*    */ import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
/*    */ 
/*    */ public class Prepare extends CustomCard {
/* 15 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Prepare"); public static final String ID = "Prepare";
/* 16 */   public static final String NAME = cardStrings.NAME;
/* 17 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   
/*    */   private static final int COST = 0;
/*    */   public static final String IMG_PATH = "img/cards/Prepare_skill.png";
/*    */   
/*    */   public Prepare() {
/* 23 */     super("Prepare", NAME, "img/cards/Prepare_skill.png", 0, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.SELF);
/* 24 */     this.baseMagicNumber = 2;
/* 25 */     this.magicNumber = this.baseMagicNumber;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 30 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new DrawCardNextTurnPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 35 */     return (AbstractCard)new Prepare();
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 40 */     if (!this.upgraded) {
/* 41 */       upgradeName();
/* 42 */       upgradeMagicNumber(1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Prepare.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */