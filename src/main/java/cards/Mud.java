/*    */ package cards;
/*    */ 
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ import com.megacrit.cardcrawl.powers.VulnerablePower;
/*    */ import com.megacrit.cardcrawl.powers.WeakPower;
/*    */ import java.util.Iterator;
/*    */ import patches.Patch;
/*    */ 
/*    */ public class Mud extends CustomCard {
/* 21 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Mud"); public static final String ID = "Mud";
/* 22 */   public static final String NAME = cardStrings.NAME;
/* 23 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/cards/Mud_skill.png";
/*    */   private static final int COST = 1;
/*    */   
/*    */   public Mud() {
/* 28 */     super("Mud", NAME, "img/cards/Mud_skill.png", 1, DESCRIPTION, AbstractCard.CardType.SKILL, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.COMMON, AbstractCard.CardTarget.ALL_ENEMY);
/* 29 */     this.baseMagicNumber = 0;
/* 30 */     this.magicNumber = this.baseMagicNumber;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 35 */     Iterator<AbstractMonster> monsterGroup = (AbstractDungeon.getCurrRoom()).monsters.monsters.iterator();
/* 36 */     this.magicNumber = Patch.countCurse();
/* 37 */     while (monsterGroup.hasNext()) {
/* 38 */       AbstractMonster mo = monsterGroup.next();
/* 39 */       addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new WeakPower((AbstractCreature)mo, this.magicNumber, false), this.magicNumber, true, AbstractGameAction.AttackEffect.NONE));
/* 40 */       addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)mo, (AbstractCreature)p, (AbstractPower)new VulnerablePower((AbstractCreature)mo, this.magicNumber, false), this.magicNumber, true, AbstractGameAction.AttackEffect.NONE));
/*    */     } 
/*    */   }
/*    */   public void calculateCardDamage(AbstractMonster mo) {
/* 44 */     this.baseMagicNumber = Patch.countCurse();
/* 45 */     super.calculateCardDamage(mo);
/*    */   }
/*    */   public void applyPowers() {
/* 48 */     this.baseMagicNumber = Patch.countCurse();
/* 49 */     super.applyPowers();
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 53 */     return (AbstractCard)new Mud();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 57 */     if (!this.upgraded) {
/* 58 */       upgradeName();
/* 59 */       upgradeBaseCost(0);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Mud.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */