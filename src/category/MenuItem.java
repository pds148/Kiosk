package category;

import menu.model.Menu;

public class MenuItem {

    // Burgers
    public final static Menu SHACK_BURGER = new Menu(1, "SHACK_BURGER", "상추, 토마토, ShackSauce로 마무리된 100% 안거스 비프 치즈버거", 0);
    public final static Menu SMOKE_SHACK = new Menu(2, "SMOKE_SHACK", "자연에서 유래된 스모크 베이컨, 다진 체리 페퍼, ShackSauce가 올라간 치즈버거", 0);
    public final static Menu SHROOM_BURGER = new Menu(3, "SHROOM_BURGER", "바삭한 포토벨로 버섯에 녹아든 미운스터와 체다 치즈, 상추, 토마토, ShackSauce로 완성된 버거", 0);
    public final static Menu SHACK_STACK = new Menu(4, "SHACK_STACK", "치즈버거와 'Shroom Burger가 겹쳐진 조합으로 상추, 토마토, ShackSauce로 마무리", 0);
    public final static Menu HAMBURGER = new Menu(5, "HAMBURGER", "상추 & 토마토 또는 베이컨 추가 가능", 0);

    // Frozen Custard
    public final static Menu SHAKE_OF_THE_WEEK = new Menu(1, "SHAKE_OF_THE_WEEK", "매주 변경되는 다양한 맛의 쉐이크", 0);
    public final static Menu RED_BEAN_SHAKE = new Menu(2, "RED_BEAN_SHAKE", "달콤한 팥을 넣은 쉐이크", 0);
    public final static Menu CUP_AND_CONE = new Menu(3, "CUP_AND_CONE", "주간 플레이버의 커스터드를 컵이나 콘에 담아 제공", 0);
    public final static Menu FLOATS = new Menu(4, "FLOATS", "루트비어나 퍼플카우 플로트에 커스터드를 얹은 음료", 0);
    public final static Menu CONCRETE = new Menu(5, "CONCRETE", "커스터드와 다양한 믹스인이 고속으로 섞인 디저트", 0);

    // Drinks
    public final static Menu SHACK_MADE_LEMONADE = new Menu(1, "SHACK_MADE_LEMONADE", "직접 만든 상큼하고 달콤한 레몬에이드", 0);
    public final static Menu FRESH_BREWED_ICED_TEA = new Menu(2, "FRESH_BREWED_ICED_TEA", "시원하고 상큼한 아이스티", 0);
    public final static Menu FIFTY_FIFTY = new Menu(3, "FIFTY_FIFTY", "레몬에이드와 아이스티의 반반 혼합음료", 0);
    public final static Menu FOUNTAIN_SODA = new Menu(4, "FOUNTAIN_SODA", "코카콜라, 다이어트 코카콜라, 코카콜라 제로, 스프라이트, 판타 오렌지, 진저 에일 등의 탄산음료", 0);
    public final static Menu ABITA_ROOT_BEER_BOTTLE = new Menu(5, "ABITA_ROOT_BEER_BOTTLE", "알코올이 없는 루트비어", 0);

    // Beer
    public final static Menu SHACK_MEISTER_ALE = new Menu(1, "SHACK_MEISTER_ALE", "쉑쉑버거를 위해 맥파이 브루잉 컴퍼니가 독점적으로 양조한 에일", 0);
    public final static Menu PALE_ALE = new Menu(2, "PALE_ALE", "깔끔하고 상쾌한 페일 에일", 0);
}

