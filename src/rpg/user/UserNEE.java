package rpg.user;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.logging.Logger;


public class UserNEE implements User {

	private final Logger logger = Logger.getLogger("UserNEELogging");
	private final String userName;
	private final UserType userType;
	private BigDecimal str;		//�U����
	private BigDecimal agi;		//�f����
	private BigDecimal hp;		//�̗�
	private HashMap<String, String> equipments = new HashMap<>(); //�����i
	
	public UserNEE(String userName,
			UserType userType,
			String str,
			String agi,
			String hp) {
		super();
		this.userName = userName;
		this.userType = userType;
		try {
			this.str = new BigDecimal(str);
			this.agi = new BigDecimal(agi);
			this.hp = new BigDecimal(hp);
		} catch (NumberFormatException e) {
			logger.severe("�s���ȓ��̓X�e�[�^�X�ł��B");
			throw e;
		}
	}

	public String getUserName() {
		return this.userName;
	}

	public UserType getUserType() {
		return this.userType;
	}

	public BigDecimal getStr() {
		return this.str;
	}

	public BigDecimal getAgi() {
		return this.agi;
	}

	public BigDecimal getHp() {
		return this.hp;
	}
	
	public HashMap<String, String> getEquipments() {
		return this.equipments;
	}

	@Override
	public void levelUp() {
		this.str = this.str.add(new BigDecimal("1"));
		this.agi = this.agi.multiply(new BigDecimal("1.1"));
		this.hp = this.hp.add(
				this.str.divide(new BigDecimal("5")));
		System.out.println(this.userName + "�����x���A�b�v���܂����I");
		System.out.println();
	}

	@Override
	public void equipWeapon(String weaponName, String strVariation) {
		try {
			this.equipments.put("weapon", weaponName);
			this.str = this.str.add(new BigDecimal(strVariation));
			System.out.println(this.userName + "�́A" + weaponName + "�𑕔����܂����B");
			System.out.println("�U���͂�" + strVariation + "�㏸���܂����B");
			System.out.println();
		} catch (NullPointerException e) {
			logger.warning("�s���ȑ����i�f�[�^�ł��B");
		} catch (NumberFormatException e) {
			logger.warning(String.format("�����i���ɕs���ȃf�[�^�����݂��܂��B"));
		}
	}

	@Override
	public void equipArmor(String armorName, String hpVariation) {
		try {
			this.equipments.put("armor", armorName);
			this.hp = this.hp.add(new BigDecimal(hpVariation));
			System.out.println(this.userName + "�́A" + armorName + "�𑕔����܂����B");
			System.out.println("HP��" + hpVariation + "�㏸���܂����B");
			System.out.println();
		} catch (NullPointerException e) {
			logger.warning("�s���ȑ����i�f�[�^�ł��B");
		} catch (NumberFormatException e) {
			logger.warning(String.format("�����i���ɕs���ȃf�[�^�����݂��܂��B"));
		}
	}



}