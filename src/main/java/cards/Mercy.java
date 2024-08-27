/*    */ package cards;
/*    */ 
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
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.WeakPower;
/*    */ 
/*    */ public class Mercy extends CustomCard {
/* 20 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Mercy"); public static final String ID = "Mercy";
/* 21 */   public static final String NAME = cardStrings.NAME;
/* 22 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/cards/Mercy_attack.png";
/*    */   private static final int COST = 1;
/*    */   private static final int ATTACK_DMG = 3;
/*    */   
/*    */   public Mercy() {
/* 28 */     super("Mercy", NAME, "img/cards/Mercy_attack.png", 1, DESCRIPTION, AbstractCard.CardType.ATTACK, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.ENEMY);
/* 29 */     this.baseDamage = 3;
/* 30 */     this.baseMagicNumber = 4;
/* 31 */     this.magicNumber = this.baseMagicNumber;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 36 */     if (m == null) {
/*    */       return;
/*    */     }
/* 39 */     addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
/* 40 */     if (m.getIntentBaseDmg() < 0) {
/* 41 */       addToTop((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)AbstractDungeon.player, (AbstractPower)new WeakPower((AbstractCreature)m, this.magicNumber, false), this.magicNumber));
/*    */     }
/*    */   }
/*    */   
/*    */   public void calculateCardDamage(AbstractMonster m) {
/* 46 */     if (m == null) {
/*    */       return;
/*    */     }
/* 49 */     int realBaseDamage = this.baseDamage;
/* 50 */     if (m.getIntentBaseDmg() >= 0) {
/* 51 */       this.baseDamage *= this.magicNumber;
/*    */     }
/* 53 */     super.calculateCardDamage(m);
/* 54 */     this.baseDamage = realBaseDamage;
/* 55 */     this.isDamageModified = (this.damage != this.baseDamage);
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 59 */     return (AbstractCard)new Mercy();
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 64 */     if (!this.upgraded) {
/* 65 */       upgradeName();
/* 66 */       upgradeMagicNumber(1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Mercy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */