/*    */ package cards;
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.EmptyDeckShuffleAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ShuffleAction;
/*    */ import com.megacrit.cardcrawl.actions.unique.GamblingChipAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class Reload extends CustomCard {
/* 16 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Reload"); public static final String ID = "Reload";
/* 17 */   public static final String NAME = cardStrings.NAME;
/* 18 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   
/*    */   private static final int COST = 0;
/*    */   public static final String IMG_PATH = "img/cards/Reload_skill.png";
/*    */   
/*    */   public Reload() {
/* 24 */     super("Reload", NAME, "img/cards/Reload_skill.png", 0, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.UNCOMMON, AbstractCard.CardTarget.SELF);
/* 25 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 30 */     addToBot((AbstractGameAction)new GamblingChipAction((AbstractCreature)AbstractDungeon.player));
/* 31 */     if (AbstractDungeon.player.discardPile.size() > 0) {
/* 32 */       addToBot((AbstractGameAction)new EmptyDeckShuffleAction());
/* 33 */       addToBot((AbstractGameAction)new ShuffleAction(AbstractDungeon.player.drawPile, false));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 39 */     return (AbstractCard)new Reload();
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 44 */     if (!this.upgraded) {
/* 45 */       upgradeName();
/* 46 */       upgradeBaseCost(0);
/* 47 */       this.exhaust = false;
/* 48 */       this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
/* 49 */       initializeDescription();
/*    */     } 
/*    */   }
    /*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Reload.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */