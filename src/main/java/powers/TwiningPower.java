/*    */ package powers;
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class TwiningPower extends AbstractPower {
/* 11 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("TwiningPower"); public static final String POWER_ID = "TwiningPower";
/* 12 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   public TwiningPower(AbstractCreature owner, int amount) {
/* 14 */     this.name = powerStrings.NAME;
/* 15 */     this.ID = "TwiningPower";
/* 16 */     this.owner = owner;
/* 17 */     this.amount = amount;
/* 18 */     this.img = new Texture("img/powers/TwiningPower32.png");
/* 19 */     this.type = AbstractPower.PowerType.BUFF;
/* 20 */     updateDescription();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void atStartOfTurn() {
/* 26 */     addToBot((AbstractGameAction)new GainEnergyAction(this.amount));
/* 27 */     flash();
/*    */   }
/*    */   
/*    */   public void updateDescription() {
/* 31 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/TwiningPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */