/*    */ package cards;
/*    */ 
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import patches.Patch;
/*    */ 
/*    */ public class Ruin extends CustomCard {
/* 16 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Ruin"); public static final String ID = "Ruin";
/* 17 */   public static final String NAME = cardStrings.NAME;
/* 18 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/cards/Ruin_attack.png";
/*    */   private static final int COST = 1;
/*    */   private static final int ATTACK_DMG = 3;
/*    */   private static final int UPGRADE_PLUS_DMG = 1;
/*    */   
/*    */   public Ruin() {
/* 25 */     super("Ruin", NAME, "img/cards/Ruin_attack.png", 1, DESCRIPTION, AbstractCard.CardType.ATTACK, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.ALL_ENEMY);
/* 26 */     this.baseDamage = 3;
/* 27 */     this.isMultiDamage = true;
/* 28 */     this.baseMagicNumber = 0;
/* 29 */     this.magicNumber = this.baseMagicNumber;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 34 */     for (int i = 0; i < Patch.countCurse(); i++) {
/* 35 */       addToBot((AbstractGameAction)new DamageAllEnemiesAction((AbstractCreature)p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.FIRE));
/*    */     }
/*    */   }
/*    */   
/*    */   public void calculateCardDamage(AbstractMonster m) {
/* 40 */     this.baseMagicNumber = Patch.countCurse();
/* 41 */     super.calculateCardDamage(m);
/*    */   }
/*    */   public void applyPowers() {
/* 44 */     this.baseMagicNumber = Patch.countCurse();
/* 45 */     super.applyPowers();
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 49 */     return (AbstractCard)new Ruin();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 53 */     if (!this.upgraded) {
/* 54 */       upgradeName();
/* 55 */       upgradeDamage(1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Ruin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */