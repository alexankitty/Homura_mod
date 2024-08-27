/*    */ package cards;
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainBlockAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class Puzzle extends CustomCard {
/* 14 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Puzzle"); public static final String ID = "Puzzle";
/* 15 */   public static final String NAME = cardStrings.NAME;
/* 16 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   private static final int COST = 1;
/*    */   public static final String IMG_PATH = "img/cards/Puzzle_skill.png";
/*    */   
/*    */   public Puzzle() {
/* 21 */     super("Puzzle", NAME, "img/cards/Puzzle_skill.png", 1, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.SELF);
/* 22 */     this.misc = 5;
/* 23 */     this.baseBlock = this.misc;
/* 24 */     this.block = this.baseBlock;
/*    */   }
/*    */   public static void loadMagicNumber() {
/* 27 */     if (AbstractDungeon.player == null || AbstractDungeon.player.masterDeck == null) {
/*    */       return;
/*    */     }
/* 30 */     AbstractDungeon.player.masterDeck.group.stream().filter(c -> c instanceof Puzzle).forEach(Puzzle::load);
/*    */   }
/*    */   private static void load(AbstractCard c) {
/* 33 */     c.baseBlock = c.misc;
/*    */   }
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 37 */     addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 43 */     return (AbstractCard)new Puzzle();
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 48 */     if (!this.upgraded) {
/* 49 */       upgradeName();
/* 50 */       this.misc += 3;
/* 51 */       this.baseBlock = this.misc;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void applyPowers() {
/* 57 */     if (this.baseBlock < this.misc) {
/* 58 */       this.baseBlock = this.misc;
/*    */     }
/* 60 */     initializeDescription();
/* 61 */     super.applyPowers();
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Puzzle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */