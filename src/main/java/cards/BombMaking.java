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
/*    */ import powers.BombMakingPower;
import powers.BombMakingUpPower;

/*    */
/*    */ public class BombMaking extends CustomCard {
/* 16 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("BombMaking"); public static final String ID = "BombMaking";
/* 17 */   public static final String NAME = cardStrings.NAME;
/* 18 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   
/*    */   private static final int COST = 1;
/*    */   public static final String IMG_PATH = "img/cards/BombMaking_power.png";
/*    */   
/*    */   public BombMaking() {
/* 24 */     super("BombMaking", NAME, "img/cards/BombMaking_power.png", 1, DESCRIPTION, AbstractCard.CardType.POWER, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.SELF);
/* 25 */     this.cardsToPreview = (AbstractCard)new IED();
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 30 */     if (this.upgraded) {
/* 31 */       addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new BombMakingUpPower((AbstractCreature)p, 1)));
/*    */     } else {
/* 33 */       addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new BombMakingPower((AbstractCreature)p, 1)));
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 40 */     return (AbstractCard)new BombMaking();
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 45 */     if (!this.upgraded) {
/* 46 */       upgradeName();
/* 47 */       this.cardsToPreview.upgrade();
/* 48 */       this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
/* 49 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/BombMaking.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */