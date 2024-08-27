/*    */ package cards;
/*    */ 
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import patches.Patch;
/*    */ 
/*    */ public class Encircle extends CustomCard {
/* 17 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Encircle"); public static final String ID = "Encircle";
/* 18 */   public static final String NAME = cardStrings.NAME;
/* 19 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/cards/Encircle_attack.png";
/*    */   private static final int COST = 1;
/*    */   private static final int ATTACK_DMG = 2;
/*    */   private static final int UPGRADE_PLUS_DMG = 1;
/*    */   
/*    */   public Encircle() {
/* 26 */     super("Encircle", NAME, "img/cards/Encircle_attack.png", 1, DESCRIPTION, AbstractCard.CardType.ATTACK, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.ENEMY);
/* 27 */     this.baseDamage = 2;
/* 28 */     this.baseMagicNumber = 0;
/* 29 */     this.magicNumber = this.baseMagicNumber;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 35 */     for (int i = 0; i < Patch.countServantNum(); i++) {
/* 36 */       addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void calculateCardDamage(AbstractMonster m) {
/* 42 */     if (m == null) {
/*    */       return;
/*    */     }
/* 45 */     this.baseMagicNumber = Patch.countServantNum();
/* 46 */     int realBaseDamage = this.baseDamage;
/* 47 */     if (m.hasPower("Minion")) {
/* 48 */       this.baseDamage *= 2;
/*    */     }
/* 50 */     super.calculateCardDamage(m);
/* 51 */     this.baseDamage = realBaseDamage;
/* 52 */     this.isDamageModified = (this.damage != this.baseDamage);
/*    */   }
/*    */   
/*    */   public void applyPowers() {
/* 56 */     this.baseMagicNumber = Patch.countServantNum();
/* 57 */     super.applyPowers();
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 61 */     return (AbstractCard)new Encircle();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 65 */     if (!this.upgraded) {
/* 66 */       upgradeName();
/* 67 */       upgradeDamage(1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Encircle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */