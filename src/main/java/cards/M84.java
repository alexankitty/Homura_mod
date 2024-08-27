/*    */ package cards;
/*    */ 
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.evacipated.cardcrawl.mod.stslib.actions.common.StunMonsterAction;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class M84 extends CustomCard {
/*    */   public static final String ID = "M84";
/* 18 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("M84");
/* 19 */   public static final String NAME = cardStrings.NAME;
/* 20 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/cards/M84_skill.png";
/*    */   private static final int COST = 3;
/*    */   
/*    */   public M84() {
/* 25 */     super("M84", NAME, "img/cards/M84_skill.png", 3, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.ALL_ENEMY);
/* 26 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 31 */     if (this.upgraded) {
/* 32 */       for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
/* 33 */         addToBot((AbstractGameAction)new StunMonsterAction(mo, (AbstractCreature)p, 1));
/*    */       }
/*    */     } else {
/* 36 */       m = AbstractDungeon.getRandomMonster();
/* 37 */       addToBot((AbstractGameAction)new StunMonsterAction(m, (AbstractCreature)p, 1));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void triggerOnManualDiscard() {
/* 43 */     addToTop((AbstractGameAction)new NewQueueCardAction((AbstractCard)this, null, false, true));
/* 44 */     AbstractDungeon.player.discardPile.group.remove(this);
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 48 */     return (AbstractCard)new M84();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 52 */     if (!this.upgraded) {
/* 53 */       upgradeName();
/* 54 */       this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
/* 55 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/M84.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */