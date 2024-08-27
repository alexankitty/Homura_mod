/*    */ package cards;
/*    */ 
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DrawCardAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class Hunt extends CustomCard {
/* 17 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Hunt"); public static final String ID = "Hunt";
/* 18 */   public static final String NAME = cardStrings.NAME;
/* 19 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   
/*    */   public static final String IMG_PATH = "img/cards/Hunt_attack.png";
/*    */   private static final int COST = 1;
/*    */   private static final int ATTACK_DMG = 8;
/*    */   
/*    */   public Hunt() {
/* 26 */     super("Hunt", NAME, "img/cards/Hunt_attack.png", 1, DESCRIPTION, AbstractCard.CardType.ATTACK, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.ENEMY);
/* 27 */     this.baseDamage = 8;
/* 28 */     this.baseMagicNumber = 1;
/* 29 */     this.magicNumber = this.baseMagicNumber;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 34 */     addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
/* 35 */     addToBot((AbstractGameAction)new DrawCardAction(this.magicNumber));
/*    */   }
/*    */   
/*    */   public void calculateCardDamage(AbstractMonster m) {
/* 39 */     if (m == null) {
/*    */       return;
/*    */     }
/* 42 */     int realBaseDamage = this.baseDamage;
/* 43 */     if (m.hasPower("Minion")) {
/* 44 */       this.baseDamage *= 2;
/*    */     }
/* 46 */     super.calculateCardDamage(m);
/* 47 */     this.baseDamage = realBaseDamage;
/* 48 */     this.isDamageModified = (this.damage != this.baseDamage);
/*    */   }
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 53 */     return (AbstractCard)new Hunt();
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 58 */     if (!this.upgraded) {
/* 59 */       upgradeName();
/* 60 */       upgradeDamage(4);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Hunt.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */