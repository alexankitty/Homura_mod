/*    */ package powers;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.StrengthPower;
/*    */ import patches.Patch;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DemonPower
/*    */   extends AbstractPower
/*    */ {
/*    */   public static final String POWER_ID = "DemonPower";
/* 25 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("DemonPower");
/* 26 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   public DemonPower(AbstractCreature owner, int amount) {
/* 28 */     this.name = powerStrings.NAME;
/* 29 */     this.ID = "DemonPower";
/* 30 */     this.owner = owner;
/* 31 */     this.img = new Texture("img/powers/DemonPower32.png");
/* 32 */     this.type = AbstractPower.PowerType.BUFF;
/* 33 */     this.amount = amount;
/* 34 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public void atEndOfTurn(boolean isPlayer) {
/* 39 */     if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
/* 40 */       int curseNum = Patch.countCurse();
/* 41 */       if (curseNum > 0 && this.amount > 0) {
/* 42 */         flash();
/* 43 */         AbstractPlayer p = AbstractDungeon.player;
/* 44 */         addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new StrengthPower((AbstractCreature)p, curseNum * this.amount), curseNum * this.amount));
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void onInitialApplication() {}
/*    */ 
/*    */   
/*    */   public void onRemove() {}
/*    */   
/*    */   public void updateDescription() {
/* 56 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/DemonPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */