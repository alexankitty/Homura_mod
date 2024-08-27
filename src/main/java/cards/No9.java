/*    */ package cards;
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import action.ServantAction;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.SlowPower;
/*    */ 
/*    */ public class No9 extends CustomCard {
/* 18 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("No9"); public static final String ID = "No9";
/* 19 */   public static final String NAME = cardStrings.NAME;
/* 20 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/cards/No9_skill.png";
/*    */   private static final int COST = 1;
/*    */   
/*    */   public No9() {
/* 25 */     super("No9", NAME, "img/cards/No9_skill.png", 1, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.ALL_ENEMY);
/* 26 */     this.baseMagicNumber = 3;
/* 27 */     this.magicNumber = this.baseMagicNumber;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void triggerWhenDrawn() {}
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 36 */     if (this.upgraded) {
/* 37 */       for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
/* 38 */         addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)AbstractDungeon.player, (AbstractPower)new SlowPower((AbstractCreature)mo, this.magicNumber), this.magicNumber, true, AbstractGameAction.AttackEffect.NONE));
/*    */       }
/*    */     } else {
/* 41 */       m = AbstractDungeon.getRandomMonster();
/* 42 */       addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)AbstractDungeon.player, (AbstractPower)new SlowPower((AbstractCreature)m, this.magicNumber), this.magicNumber, true, AbstractGameAction.AttackEffect.NONE));
/*    */     } 
/*    */   }
/*    */   
/*    */   public void triggerOnManualDiscard() {
/* 47 */     addToBot((AbstractGameAction)new ServantAction((AbstractCard)this, false));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 51 */     return (AbstractCard)new No9();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 55 */     if (!this.upgraded) {
/* 56 */       upgradeName();
/* 57 */       this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
/* 58 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/No9.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */