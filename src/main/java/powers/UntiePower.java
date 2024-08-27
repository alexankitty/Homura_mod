/*    */ package powers;
/*    */ 
/*    */ import com.badlogic.gdx.graphics.Texture;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.localization.PowerStrings;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class UntiePower extends AbstractPower {
/* 10 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("UntiePower"); public static final String POWER_ID = "UntiePower";
/* 11 */   public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   public UntiePower(AbstractCreature owner) {
/* 13 */     this.name = powerStrings.NAME;
/* 14 */     this.ID = "UntiePower";
/* 15 */     this.owner = owner;
/* 16 */     this.img = new Texture("img/powers/UntiePower32.png");
/* 17 */     this.type = AbstractPower.PowerType.BUFF;
/* 18 */     updateDescription();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void atStartOfTurn() {}
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 27 */     this.description = DESCRIPTIONS[0];
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/powers/UntiePower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */