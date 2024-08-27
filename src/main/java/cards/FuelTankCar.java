/*    */ package cards;
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.VulnerablePower;
/*    */ import com.megacrit.cardcrawl.powers.WeakPower;
/*    */ 
/*    */ public class FuelTankCar extends CustomCard {
/* 19 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("FuelTankCar"); public static final String ID = "FuelTankCar";
/* 20 */   public static final String NAME = cardStrings.NAME;
/* 21 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   
/*    */   public static final String IMG_PATH = "img/cards/FuelTankCar_attack.png";
/*    */   private static final int COST = 3;
/*    */   private static final int ATTACK_DMG = 24;
/*    */   private static final int UPGRADE_PLUS_DMG = 6;
/*    */   
/*    */   public FuelTankCar() {
/* 29 */     super("FuelTankCar", NAME, "img/cards/FuelTankCar_attack.png", 3, DESCRIPTION, AbstractCard.CardType.ATTACK, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.ENEMY);
/* 30 */     this.baseDamage = 24;
/* 31 */     this.exhaust = true;
/* 32 */     this.baseMagicNumber = 3;
/* 33 */     this.magicNumber = this.baseMagicNumber;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 38 */     addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
/* 39 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new WeakPower((AbstractCreature)m, this.magicNumber, false), this.magicNumber, true, AbstractGameAction.AttackEffect.NONE));
/* 40 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new VulnerablePower((AbstractCreature)m, this.magicNumber, false), this.magicNumber, true, AbstractGameAction.AttackEffect.NONE));
/*    */   }
/*    */   
/*    */   public void calculateCardDamage(AbstractMonster m) {
/* 44 */     if (m == null) {
/*    */       return;
/*    */     }
/* 47 */     int realBaseDamage = this.baseDamage;
/* 48 */     if (m.currentBlock > 0) {
/* 49 */       this.baseDamage *= 2;
/*    */     }
/* 51 */     super.calculateCardDamage(m);
/* 52 */     this.baseDamage = realBaseDamage;
/* 53 */     this.isDamageModified = (this.damage != this.baseDamage);
/*    */   }
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 58 */     return (AbstractCard)new FuelTankCar();
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 63 */     if (!this.upgraded) {
/*    */       
/* 65 */       upgradeName();
/* 66 */       upgradeDamage(6);
/* 67 */       upgradeMagicNumber(2);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/FuelTankCar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */