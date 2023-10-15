package hibob;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

public class AsOfDate {

    public static void main(String[] args) {
        Role roleOneMoment1 = new Role("manager", LocalDateTime.now().minusDays(15));
        Role roleOneMoment2 = new Role("manager", LocalDateTime.now().minusDays(5));
        Role roleOneMoment3 = new Role("manager", LocalDateTime.now());
        Role roleTwoMoment1 = new Role("admin", LocalDateTime.now().minusDays(15));
        Role roleTwoMoment2 = new Role("admin", LocalDateTime.now().minusDays(2));
        Role roleTwoMoment3 = new Role("admin", LocalDateTime.now());
        List<Role> roles = List.of(roleOneMoment1, roleOneMoment2, roleOneMoment3, roleTwoMoment1, roleTwoMoment2, roleTwoMoment3);

        AsOfDate main = new AsOfDate();
        Role roleAsOfDate = main.getRoleAsOfDate("manager", LocalDateTime.now().minusDays(4), roles);
        System.out.println(roleAsOfDate);
    }

    public Role getRoleAsOfDate(String roleName, LocalDateTime effectiveDate, List<Role> roles) {
        Map<String, List<Role>> rolesByName = new HashMap<>();
        for (Role role : roles) {
            List<Role> roleList = rolesByName.get(role.name);
            if (roleList == null) {
                roleList = new ArrayList<>();
            }
            roleList.add(role);
            rolesByName.put(role.name, roleList);
        }
        for (List<Role> roleList : rolesByName.values()) {
            roleList.sort(Comparator.comparing(o -> o.date));
        }

        List<Role> roleList = rolesByName.get(roleName);
        if (roleList == null || roleList.isEmpty()) return null;

        return binarySearchAsOfDate(roleList, effectiveDate, 0, roleList.size() - 1);

    }

    private Role binarySearchAsOfDate(List<Role> roles, LocalDateTime effectiveDate, int start, int end) {
        Role startRole = roles.get(start);
        if (startRole.date.isEqual(effectiveDate)) {
            return startRole;
        }

        Role endRole = roles.get(end);
        if (endRole.date.isEqual(effectiveDate)) {
            return endRole;
        }

        if (start >= end) {
            return endRole;
        } else if (end - start == 1) {
            long diffFromStart = getDiffBetweenDates(startRole.date, effectiveDate);
            long diffFromEnd = getDiffBetweenDates(endRole.date, effectiveDate);
            return diffFromStart <= diffFromEnd ? startRole : endRole;
        }

        int middle = start + (end - start) / 2;
        Role middleRole = roles.get(middle);
        if (middleRole.date.isEqual(effectiveDate)) {
            return middleRole;
        } else if (effectiveDate.isBefore(middleRole.date)) {
            return binarySearchAsOfDate(roles, effectiveDate, start, middle);
        } else {
            return binarySearchAsOfDate(roles, effectiveDate, middle, end);
        }
    }

    private long getDiffBetweenDates(LocalDateTime date1, LocalDateTime date2) {
        return date1.toEpochSecond(ZoneOffset.UTC) - date2.toEpochSecond(ZoneOffset.UTC);
    }

    private static class Role {
        String name;
        LocalDateTime date;

        public Role(String name, LocalDateTime date) {
            this.name = name;
            this.date = date;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Role role = (Role) o;

            if (!Objects.equals(name, role.name)) return false;
            return Objects.equals(date, role.date);
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (date != null ? date.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Role{" +
                    "name='" + name + '\'' +
                    ", date=" + date +
                    '}';
        }
    }
}
