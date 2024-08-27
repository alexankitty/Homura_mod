/*    */ package relics;
/*    */ 
/*    */ import basemod.abstracts.CustomRelic;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DrawCardAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
/*    */ import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
/*    */ import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
/*    */ import com.megacrit.cardcrawl.actions.utility.UseCardAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.helpers.ImageMaster;
/*    */ import com.megacrit.cardcrawl.relics.AbstractRelic;
/*    */ import java.util.ArrayList;
/*    */ import patches.Patch;
/*    */ 
/*    */ public class SoulGem_Demon
/*    */   extends CustomRelic {
/*    */   public static final String ID = "SoulGem_Demon";
/*    */   private static final String IMG = "img/relics/SoulGem_Demon.png";
/*    */   
/*    */   public SoulGem_Demon() {
/* 25 */     super("SoulGem_Demon", ImageMaster.loadImage("img/relics/SoulGem_Demon.png"), ImageMaster.loadImage("img/relics/outline/SoulGem_Demon.png"), AbstractRelic.RelicTier.BOSS, AbstractRelic.LandingSound.CLINK);
/* 26 */     this.counter = 0;
/*    */   }
/*    */   private static final String IMG_OTL = "img/relics/outline/SoulGem_Demon.png"; private boolean triggeredThisTurn = false;
/*    */   
/*    */   public void atBattleStart() {
/* 31 */     this.counter = 0;
/*    */   }
/*    */   
/*    */   public void atTurnStart() {
/* 35 */     this.triggeredThisTurn = false;
/*    */   }
/*    */   
/*    */   public void onUseCard(AbstractCard card, UseCardAction action) {
/* 39 */     if (Patch.isServant(card) != 0 && !this.triggeredThisTurn) {
/* 40 */       this.triggeredThisTurn = true;
/* 41 */       flash();
/* 42 */       addToBot((AbstractGameAction)new RelicAboveCreatureAction((AbstractCreature)AbstractDungeon.player, (AbstractRelic)this));
/* 43 */       addToBot((AbstractGameAction)new GainEnergyAction(1));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void onCardDraw(AbstractCard card) {
/* 49 */     if (Patch.isServant(card) != 0) {
/* 50 */       flash();
/* 51 */       addToBot((AbstractGameAction)new DrawCardAction(1));
/*    */     } 
/*    */     
/* 54 */     if (card.type == AbstractCard.CardType.CURSE) {
/* 55 */       flash();
/* 56 */       if (card.type == AbstractCard.CardType.CURSE) {
/* 57 */         flash();
/* 58 */         AbstractPlayer p = AbstractDungeon.player;
/* 59 */         p.hand.moveToExhaustPile(card);
/* 60 */         this.counter++;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void onPlayerEndTurn() {
/* 67 */     if (this.counter > 0) {
/* 68 */       ArrayList<AbstractCard> cl = Patch.getServant(this.counter);
/* 69 */       for (AbstractCard c : cl) {
/* 70 */         addToBot((AbstractGameAction)new MakeTempCardInDiscardAction(c, 1));
/*    */       }
/* 72 */       this.counter = 0;
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean canSpawn() {
/* 77 */     return AbstractDungeon.player.hasRelic("MetalShield");
/*    */   }
/*    */   
/*    */   public void obtain() {
/* 81 */     if (AbstractDungeon.player.hasRelic("MetalShield")) {
/* 82 */       AbstractDungeon.player.getRelic("MetalShield").onUnequip();
/* 83 */       instantObtain(AbstractDungeon.player, 0, false);
/*    */     } else {
/* 85 */       super.obtain();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getUpdatedDescription() {
/* 92 */     return this.DESCRIPTIONS[0];
/*    */   }
/*    */ 
/*    */   
/*    */   public AbstractRelic makeCopy() {
/* 97 */     return (AbstractRelic)new SoulGem_Demon();
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/relics/SoulGem_Demon.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */