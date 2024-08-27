/*    */ package powers;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.utility.UseCardAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import java.util.Iterator;
/*    */ 
/*    */ public class ZeroEnergePower extends AbstractPower {
/* 16 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("ZeroEnergePower"); public static final String POWER_ID = "ZeroEnergePower";
/* 17 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   public ZeroEnergePower(AbstractCreature owner) {
/* 19 */     this.name = powerStrings.NAME;
/* 20 */     this.ID = "ZeroEnergePower";
/* 21 */     this.owner = owner;
/* 22 */     this.img = new Texture("img/powers/ZeroEnergePower32.png");
/* 23 */     this.type = AbstractPower.PowerType.BUFF;
/* 24 */     updateDescription();
/*    */   }
/*    */   
/*    */   public void onInitialApplication() {
/* 28 */     CardCrawlGame.sound.play("TimeStop");
/* 29 */     Iterator<AbstractCard> var1 = AbstractDungeon.player.hand.group.iterator();
/* 30 */     while (var1.hasNext()) {
/* 31 */       AbstractCard c = var1.next();
/* 32 */       if (c.costForTurn == 0) {
/* 33 */         c.isCostModifiedForTurn = false;
/*    */         continue;
/*    */       } 
/* 36 */       c.setCostForTurn(0);
/*    */     } 
/* 38 */     var1 = AbstractDungeon.player.drawPile.group.iterator();
/* 39 */     while (var1.hasNext()) {
/* 40 */       AbstractCard c = var1.next();
/* 41 */       if (c.costForTurn == 0) {
/* 42 */         c.isCostModifiedForTurn = false;
/*    */         continue;
/*    */       } 
/* 45 */       c.setCostForTurn(0);
/*    */     } 
/* 47 */     var1 = AbstractDungeon.player.discardPile.group.iterator();
/* 48 */     while (var1.hasNext()) {
/* 49 */       AbstractCard c = var1.next();
/* 50 */       if (c.costForTurn == 0) {
/* 51 */         c.isCostModifiedForTurn = false;
/*    */         continue;
/*    */       } 
/* 54 */       c.setCostForTurn(0);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void onUseCard(AbstractCard card, UseCardAction action) {
/* 59 */     flash();
/* 60 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new RemoveSpecificPowerAction(this.owner, this.owner, "ZeroEnergePower"));
/*    */   }
/*    */   
/*    */   public void onRemove() {
/* 64 */     Iterator<AbstractCard> var1 = AbstractDungeon.player.hand.group.iterator();
/* 65 */     while (var1.hasNext()) {
/* 66 */       AbstractCard c = var1.next();
/* 67 */       if (c.isCostModifiedForTurn) {
/* 68 */         c.costForTurn = c.cost;
/* 69 */         c.isCostModifiedForTurn = false;
/*    */       } 
/*    */     } 
/* 72 */     var1 = AbstractDungeon.player.drawPile.group.iterator();
/* 73 */     while (var1.hasNext()) {
/* 74 */       AbstractCard c = var1.next();
/* 75 */       if (c.isCostModifiedForTurn) {
/* 76 */         c.costForTurn = c.cost;
/* 77 */         c.isCostModifiedForTurn = false;
/*    */       } 
/*    */     } 
/* 80 */     var1 = AbstractDungeon.player.discardPile.group.iterator();
/* 81 */     while (var1.hasNext()) {
/* 82 */       AbstractCard c = var1.next();
/* 83 */       if (c.isCostModifiedForTurn) {
/* 84 */         c.costForTurn = c.cost;
/* 85 */         c.isCostModifiedForTurn = false;
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void atEndOfTurn(boolean isPlayer) {
/* 91 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new RemoveSpecificPowerAction(this.owner, this.owner, "ZeroEnergePower"));
/*    */   }
/*    */   
/*    */   public void updateDescription() {
/* 95 */     this.description = DESCRIPTIONS[0];
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/ZeroEnergePower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */