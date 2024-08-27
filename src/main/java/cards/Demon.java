/*    */ package cards;
/*    */ import EgoMod.AbstractCardEnum;
/*    */ import EgoMod.HomuraMod;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.animations.VFXAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.InstantKillAction;
/*    */ import com.megacrit.cardcrawl.actions.utility.WaitAction;
/*    */ import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.core.CardCrawlGame;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.localization.CardStrings;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.stances.AbstractStance;
/*    */ import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.combat.GrandFinalEffect;
import patches.Patch;
/*    */ import stance.DemonStance;
/*    */ 
/*    */ public class Demon extends CustomCard {
/* 22 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Demon"); public static final String ID = "Demon";
/* 23 */   public static final String NAME = cardStrings.NAME;
/* 24 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/cards/Demon_attack.png";
/*    */   private static final int COST = 3;
           private static final int ATTACK_DMG = 10;
/*    */   
/*    */   public Demon() {
/* 29 */     super("Demon", NAME, "img/cards/Demon_attack.png", 3, DESCRIPTION, AbstractCard.CardType.ATTACK, AbstractCardEnum.Homura_COLOR, AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.ALL_ENEMY);
/* 30 */     this.baseMagicNumber = 0;
             this.baseDamage = 10;
/* 31 */     this.magicNumber = this.baseMagicNumber;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 36 */     if (HomuraMod.isSchoolUniform || HomuraMod.isMagicalGirl) {
/* 37 */       addToBot((AbstractGameAction)new ChangeStanceAction((AbstractStance)new DemonStance()));
/*    */     }
             int hitCount = Patch.countServantNum() + Patch.countCurse();
/* 40 */     addToBot((AbstractGameAction)new VFXAction((AbstractGameEffect)new GrandFinalEffect(), 1.0F));
/* 41 */     for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
/* 42 */       if (mo.currentHealth > 0) {
/* 43 */         for (int i = 0; i < 3; i++) {
/* 44 */           addToBot((AbstractGameAction)new WaitAction(0.1F));
/*    */         }
                if(mo.type != AbstractMonster.EnemyType.NORMAL){
                    for (int i = 0; i < hitCount; i++) {
                        addToBot((AbstractGameAction)new DamageAction((AbstractCreature)mo, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.FIRE));
                    }
                }
                else{
                    addToBot((AbstractGameAction)new InstantKillAction((AbstractCreature)mo));
                }
/*    */       }
/*    */     } 
/*    */   }

/*    */   public void calculateCardDamage(AbstractMonster m) {
/* 61 */     this.baseMagicNumber = Patch.countServantNum() + Patch.countCurse();
/* 62 */     super.calculateCardDamage(m);
/*    */   }
/*    */   public void applyPowers() {
/* 65 */     this.baseMagicNumber = Patch.countServantNum() + Patch.countCurse();
/* 66 */     super.applyPowers();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean canUse(AbstractPlayer p, AbstractMonster m) {
/* 72 */     boolean canUse = super.canUse(p, m);
/* 73 */     if (!canUse) {
/* 74 */       return false;
/*    */     }
/* 76 */     if (this.baseMagicNumber < 15) {
/* 77 */       canUse = false;
/*    */     }
/* 79 */     return canUse;
/*    */   }
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 84 */     return (AbstractCard)new Demon();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 88 */     if (!this.upgraded) {
/* 89 */       upgradeName();
/* 90 */       this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
/* 91 */       initializeDescription();
/* 92 */       this.selfRetain = true;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /mnt/nyoom/SteamLibrary/steamapps/workshop/content/646570/2640024018/Homura_mod.jar!/cards/Demon.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */