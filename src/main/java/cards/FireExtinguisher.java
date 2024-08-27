/*    */ package cards;
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.unique.RemoveDebuffsAction;
/*    */ import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.IntangiblePlayerPower;

/*    */
/*    */ public class FireExtinguisher extends CustomCard {
/* 18 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("FireExtinguisher"); public static final String ID = "FireExtinguisher";
/* 19 */   public static final String NAME = cardStrings.NAME;
/* 20 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/cards/FireExtinguisher_skill.png";
/*    */   private static final int COST = 2;
/*    */   
/*    */   public FireExtinguisher() {
/* 25 */     super("FireExtinguisher", NAME, "img/cards/FireExtinguisher_skill.png", 2, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.ALL_ENEMY);
/* 26 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 31 */     if (this.upgraded) {
/* 32 */       addToBot((AbstractGameAction)new RemoveDebuffsAction((AbstractCreature)AbstractDungeon.player));
/*    */     }
/* 34 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new IntangiblePlayerPower((AbstractCreature)p, 1), 1));
/*    */   }
/*    */ 
/*    */   
/*    */   public void triggerOnManualDiscard() {
/* 39 */     addToTop((AbstractGameAction)new NewQueueCardAction((AbstractCard)this, null, false, true));
/* 40 */     AbstractDungeon.player.discardPile.group.remove(this);
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 44 */     return (AbstractCard)new FireExtinguisher();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 48 */     if (!this.upgraded) {
/* 49 */       upgradeName();
/* 50 */       this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
/* 51 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/FireExtinguisher.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */