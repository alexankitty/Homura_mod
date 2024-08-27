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
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class No10 extends CustomCard {
/* 18 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("No10"); public static final String ID = "No10";
/* 19 */   public static final String NAME = cardStrings.NAME;
/* 20 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   
/*    */   public static final String IMG_PATH = "img/cards/No10_attack.png";
/*    */   private static final int COST = 1;
/*    */   
/*    */   public No10() {
/* 26 */     super("No10", NAME, "img/cards/No10_attack.png", 1, DESCRIPTION, AbstractCard.CardType.ATTACK, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.ENEMY);
/* 27 */     this.baseDamage = 0;
/* 28 */     this.damage = this.baseDamage;
/* 29 */     this.baseMagicNumber = 3;
/* 30 */     this.magicNumber = this.baseMagicNumber;
/*    */   }
/*    */ 
/*    */   
/*    */   public void triggerWhenDrawn() {}
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 38 */     addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
/*    */   }
/*    */ 
/*    */   
/*    */   public void triggerOnManualDiscard() {
/* 43 */     addToBot((AbstractGameAction)new ServantAction((AbstractCard)this, false));
/*    */   }
/*    */   public void calculateCardDamage(AbstractMonster m) {
/* 46 */     this.baseDamage = AbstractDungeon.player.gold / 50 * this.magicNumber;
/* 47 */     super.calculateCardDamage(m);
/*    */   }
/*    */   public void applyPowers() {
/* 50 */     this.baseDamage = AbstractDungeon.player.gold / 50 * this.magicNumber;
/* 51 */     super.applyPowers();
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 55 */     return (AbstractCard)new No10();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 59 */     if (!this.upgraded) {
/* 60 */       upgradeName();
/* 61 */       upgradeMagicNumber(1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/No10.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */