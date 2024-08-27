/*    */ package cards;
/*    */ 
/*    */ import EgoMod.HomuraMod;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.core.Settings;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.vfx.NecronomicurseEffect;
/*    */ 
/*    */ public class CauseAndEffect extends CustomCard {
/* 17 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("CauseAndEffect"); public static final String ID = "CauseAndEffect";
/* 18 */   public static final String NAME = cardStrings.NAME;
/* 19 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   
/*    */   private static final int COST = -2;
/*    */   
/*    */   public static final String IMG_PATH = "img/cards/CauseAndEffect.png";
/*    */   
/*    */   public CauseAndEffect() {
/* 26 */     super("CauseAndEffect", NAME, "img/cards/CauseAndEffect.png", -2, DESCRIPTION, AbstractCard.CardType.CURSE, AbstractCard.CardColor.CURSE, AbstractCard.CardRarity.SPECIAL, AbstractCard.CardTarget.NONE);
/* 27 */     this.baseMagicNumber = 0;
/* 28 */     this.magicNumber = this.baseMagicNumber;
/*    */   }
/*    */   public static void loadGame() {
/* 31 */     if (AbstractDungeon.player == null || AbstractDungeon.player.masterDeck == null) {
/*    */       return;
/*    */     }
/* 34 */     AbstractDungeon.player.masterDeck.group.stream().filter(c -> c instanceof CauseAndEffect).forEach(CauseAndEffect::load);
/*    */   }
/*    */   
/*    */   private static void load(AbstractCard c) {
/* 38 */     c.baseMagicNumber = HomuraMod.getSaveLoadCount();
/* 39 */     c.magicNumber = c.baseMagicNumber;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {}
/*    */   
/*    */   public void onRemoveFromMasterDeck() {
/* 46 */     AbstractDungeon.effectsQueue.add(new NecronomicurseEffect((AbstractCard)new CauseAndEffect(), Settings.WIDTH / 2.0F, Settings.HEIGHT / 2.0F));
/* 47 */     load((AbstractCard)this);
/*    */   }
/*    */   public void triggerOnExhaust() {
/* 50 */     addToBot((AbstractGameAction)new MakeTempCardInHandAction(makeCopy()));
/* 51 */     load((AbstractCard)this);
/*    */   }
/*    */   public void calculateCardDamage(AbstractMonster m) {
/* 54 */     this.baseMagicNumber = HomuraMod.getSaveLoadCount();
/* 55 */     this.magicNumber = this.baseMagicNumber;
/*    */   }
/*    */   public void applyPowers() {
/* 58 */     this.baseMagicNumber = HomuraMod.getSaveLoadCount();
/* 59 */     this.magicNumber = this.baseMagicNumber;
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 63 */     return (AbstractCard)new CauseAndEffect();
/*    */   }
/*    */   
/*    */   public void upgrade() {}
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/CauseAndEffect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */