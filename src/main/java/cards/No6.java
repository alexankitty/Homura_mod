/*    */ package cards;
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import action.ServantAction;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.cards.curses.Regret;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.ConstrictedPower;
/*    */ 
/*    */ public class No6 extends CustomCard {
/* 21 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("No6"); public static final String ID = "No6";
/* 22 */   public static final String NAME = cardStrings.NAME;
/* 23 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/cards/No6_attack.png";
/*    */   private static final int COST = 1;
/*    */   private static final int ATTACK_DMG = 8;
/*    */   
/*    */   public No6() {
/* 29 */     super("No6", NAME, "img/cards/No6_attack.png", 1, DESCRIPTION, AbstractCard.CardType.ATTACK, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.ENEMY);
/* 30 */     this.baseDamage = 8;
/* 31 */     this.baseMagicNumber = 3;
/* 32 */     this.magicNumber = this.baseMagicNumber;
/* 33 */     this.cardsToPreview = (AbstractCard)new Regret();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void triggerWhenDrawn() {}
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 42 */     addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
/* 43 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new ConstrictedPower((AbstractCreature)m, (AbstractCreature)p, this.magicNumber)));
/* 44 */     addToBot((AbstractGameAction)new MakeTempCardInDiscardAction((new Regret()).makeCopy(), 1));
/*    */   }
/*    */   
/*    */   public void triggerOnManualDiscard() {
/* 48 */     addToBot((AbstractGameAction)new ServantAction((AbstractCard)this, false));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 52 */     return (AbstractCard)new No6();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 56 */     if (!this.upgraded) {
/* 57 */       upgradeName();
/* 58 */       upgradeDamage(2);
/* 59 */       upgradeMagicNumber(2);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/No6.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */