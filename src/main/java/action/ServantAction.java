/*    */ package action;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
/*    */ import com.megacrit.cardcrawl.actions.utility.UnlimboAction;
/*    */ import com.megacrit.cardcrawl.actions.utility.WaitAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.Settings;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ 
/*    */ public class ServantAction extends AbstractGameAction {
/*    */   private final boolean exhaustCards;
/*    */   
/*    */   public ServantAction(AbstractCard card, boolean exhausts) {
/* 15 */     this.duration = Settings.ACTION_DUR_FAST;
/* 16 */     this.actionType = AbstractGameAction.ActionType.WAIT;
/* 17 */     this.source = (AbstractCreature)AbstractDungeon.player;
/* 18 */     this.exhaustCards = exhausts;
/* 19 */     this.card = card;
/*    */   }
/*    */   private final AbstractCard card;
/*    */   
/*    */   public void update() {
/* 24 */     if (this.duration == Settings.ACTION_DUR_FAST) {
/* 25 */       this.target = (AbstractCreature)(AbstractDungeon.getCurrRoom()).monsters.getRandomMonster(null, true, AbstractDungeon.cardRandomRng);
/* 26 */       System.out.println(this.card.name);
/* 27 */       if (this.target == null) {
/* 28 */         this.isDone = true;
/*    */         return;
/*    */       } 
/* 31 */       if (AbstractDungeon.player.discardPile.findCardById(this.card.cardID) != null) {
/* 32 */         AbstractDungeon.player.discardPile.group.remove(this.card);
/*    */       }
/* 34 */       if (AbstractDungeon.player.drawPile.findCardById(this.card.cardID) != null) {
/* 35 */         AbstractDungeon.player.drawPile.group.remove(this.card);
/*    */       }
/*    */       
/* 38 */       (AbstractDungeon.getCurrRoom()).souls.remove(this.card);
/* 39 */       this.card.exhaustOnUseOnce = this.exhaustCards;
/* 40 */       AbstractDungeon.player.limbo.group.add(this.card);
/* 41 */       this.card.current_y = -200.0F * Settings.scale;
/* 42 */       this.card.target_x = Settings.WIDTH / 2.0F + 200.0F * Settings.xScale;
/* 43 */       this.card.target_y = Settings.HEIGHT / 2.0F;
/* 44 */       this.card.targetAngle = 0.0F;
/* 45 */       this.card.lighten(false);
/* 46 */       this.card.drawScale = 0.12F;
/* 47 */       this.card.targetDrawScale = 0.75F;
/* 48 */       this.card.applyPowers();
/* 49 */       addToTop((AbstractGameAction)new NewQueueCardAction(this.card, this.target, false, true));
/* 50 */       addToTop((AbstractGameAction)new UnlimboAction(this.card));
/* 51 */       if (!Settings.FAST_MODE) {
/* 52 */         addToTop((AbstractGameAction)new WaitAction(Settings.ACTION_DUR_MED));
/*    */       } else {
/* 54 */         addToTop((AbstractGameAction)new WaitAction(Settings.ACTION_DUR_FASTER));
/*    */       } 
/* 56 */       this.isDone = true;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/action/ServantAction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */