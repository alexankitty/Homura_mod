/*    */ package cards;
/*    */ 
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class M249 extends CustomCard {
/*    */   public static final String ID = "M249";
/* 15 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("M249");
/* 16 */   public static final String NAME = cardStrings.NAME;
/* 17 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/cards/M249_attack.png";
/*    */   private static final int COST = 2;
/*    */   
/*    */   public M249() {
/* 22 */     super("M249", NAME, "img/cards/M249_attack.png", 2, DESCRIPTION, AbstractCard.CardType.ATTACK, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.ALL_ENEMY);
/* 23 */     this.baseDamage = 4;
/* 24 */     this.baseMagicNumber = 4;
/* 25 */     this.magicNumber = this.baseMagicNumber;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 30 */     for (int i = 0; i < this.magicNumber; i++) {
/* 31 */       addToBot((AbstractGameAction)new AttackDamageRandomEnemyAction((AbstractCard)this, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 38 */     return (AbstractCard)new M249();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 42 */     if (!this.upgraded) {
/* 43 */       upgradeName();
/* 44 */       upgradeMagicNumber(2);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/M249.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */