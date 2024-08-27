/*    */ package action;
/*    */ 
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.vfx.GainPennyEffect;
/*    */ import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;
/*    */ 
/*    */ public class No10Action
/*    */   extends AbstractGameAction
/*    */ {
/*    */   private final DamageInfo info;
/*    */   private static final float DURATION = 0.1F;
/*    */   
/*    */   public No10Action(AbstractCreature target, DamageInfo info) {
/* 19 */     this.info = info;
/* 20 */     setValues(target, info);
/* 21 */     this.actionType = AbstractGameAction.ActionType.DAMAGE;
/* 22 */     this.duration = 0.1F;
/*    */   }
/*    */   
/*    */   public void update() {
/* 26 */     if (this.duration == 0.1F && this.target != null) {
/* 27 */       int res; AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.target.hb.cX, this.target.hb.cY, AbstractGameAction.AttackEffect.BLUNT_HEAVY));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 35 */       AbstractMonster mon = (AbstractMonster)this.target;
/*    */       
/* 37 */       int tmp = mon.currentHealth;
/*    */       
/* 39 */       this.target.damage(this.info);
/*    */ 
/*    */ 
/*    */       
/* 43 */       if (this.target.isDying || this.target.currentHealth <= 0) {
/* 44 */         res = tmp;
/*    */       } else {
/* 46 */         res = tmp - mon.currentHealth;
/*    */       } 
/*    */       
/* 49 */       AbstractPlayer p = AbstractDungeon.player;
/*    */       
/* 51 */       p.gainGold(res);
/* 52 */       for (int i = 0; i < res; i++) {
/* 53 */         AbstractDungeon.effectList.add(new GainPennyEffect((AbstractCreature)p, this.target.hb.cX, this.target.hb.cY, p.hb.cX, p.hb.cY, true));
/*    */       }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 65 */       if ((AbstractDungeon.getCurrRoom()).monsters.areMonstersBasicallyDead()) {
/* 66 */         AbstractDungeon.actionManager.clearPostCombatActions();
/*    */       }
/*    */     } 
/* 69 */     tickDuration();
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/action/No10Action.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */