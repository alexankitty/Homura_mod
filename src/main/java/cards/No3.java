/*    */ package cards;
/*    */ 
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import action.ServantAction;
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
/*    */ 
/*    */ public class No3 extends CustomCard {
/* 17 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("No3"); public static final String ID = "No3";
/* 18 */   public static final String NAME = cardStrings.NAME;
/* 19 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/cards/No3_attack.png";
/*    */   private static final int COST = 1;
/*    */   private static final int ATTACK_DMG = 6;
/*    */   
/*    */   public No3() {
/* 25 */     super("No3", NAME, "img/cards/No3_attack.png", 1, DESCRIPTION, AbstractCard.CardType.ATTACK, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.ENEMY);
/* 26 */     this.baseDamage = 6;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void triggerWhenDrawn() {}
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 35 */     if (m == null) {
/*    */       return;
/*    */     }
/* 38 */     addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
/*    */     
/* 40 */     m.rollMove();
/* 41 */     m.createIntent();
/*    */   }
/*    */ 
/*    */   
/*    */   public void triggerOnManualDiscard() {
/* 46 */     addToBot((AbstractGameAction)new ServantAction((AbstractCard)this, false));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 50 */     return (AbstractCard)new No3();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 54 */     if (!this.upgraded) {
/* 55 */       upgradeName();
/* 56 */       this.selfRetain = true;
/* 57 */       this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
/* 58 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/No3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */