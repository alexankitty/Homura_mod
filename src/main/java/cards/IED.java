/*    */ package cards;
/*    */ 
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
/*    */ import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class IED extends CustomCard {
/* 17 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("IED"); public static final String ID = "IED";
/* 18 */   public static final String NAME = cardStrings.NAME;
/* 19 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/cards/IED_attack.png";
/*    */   private static final int COST = 1;
/*    */   private static final int ATTACK_DMG = 7;
/*    */   private static final int UPGRADE_PLUS_DMG = 3;
/*    */   
/*    */   public IED() {
/* 26 */     super("IED", NAME, "img/cards/IED_attack.png", 1, DESCRIPTION, AbstractCard.CardType.ATTACK, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.BASIC, AbstractCard.CardTarget.ALL_ENEMY);
/* 27 */     this.baseDamage = 7;
/* 28 */     this.isMultiDamage = true;
/* 29 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 34 */     addToBot((AbstractGameAction)new DamageAllEnemiesAction((AbstractCreature)p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.FIRE));
/*    */   }
/*    */   
/*    */   public void triggerOnManualDiscard() {
/* 38 */     addToTop((AbstractGameAction)new NewQueueCardAction((AbstractCard)this, null, false, true));
/* 39 */     AbstractDungeon.player.discardPile.group.remove(this);
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 43 */     return (AbstractCard)new IED();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 47 */     if (!this.upgraded) {
/* 48 */       upgradeName();
/* 49 */       upgradeDamage(3);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/IED.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */