/*    */ package powers;
/*    */ 
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class TimeBombPower extends AbstractPower {
/*    */   public static final String POWER_ID = "TimeBombPower";
/* 14 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("TimeBombPower");
/* 15 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/* 16 */   public static final String NAME = powerStrings.NAME;
/*    */   private int damage;
/*    */   private static int bombIdOffset;
/*    */   
/*    */   public TimeBombPower(AbstractCreature owner, int turns, int damage) {
/* 21 */     this.name = NAME;
/* 22 */     this.ID = "TimeBombPower" + bombIdOffset;
/* 23 */     bombIdOffset++;
/* 24 */     this.owner = owner;
/* 25 */     this.amount = turns;
/* 26 */     this.damage = damage;
/* 27 */     this.type = AbstractPower.PowerType.DEBUFF;
/* 28 */     updateDescription();
/* 29 */     loadRegion("the_bomb");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void atEndOfTurn(boolean isPlayer) {
/* 35 */     addToBot((AbstractGameAction)new ReducePowerAction(this.owner, this.owner, this, 1));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void atStartOfTurn() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void onRemove() {
/* 46 */     addToBot((AbstractGameAction)new DamageAction(this.owner, new DamageInfo(this.owner, this.damage), AbstractGameAction.AttackEffect.FIRE));
/*    */   }
/*    */   
/*    */   public void updateDescription() {
/* 50 */     this.description = DESCRIPTIONS[0] + this.damage + DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/TimeBombPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */