package ar.com.lifeinsurtech.certificate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
@Table(name="users")
@RequiredArgsConstructor
@AllArgsConstructor
public class User implements GenericSystemElement {

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWalletAddress() {
		return walletAddress;
	}

	public void setWalletAddress(String walletAddress) {
		this.walletAddress = walletAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCvu() {
		return cvu;
	}

	public void setCvu(String cvu) {
		this.cvu = cvu;
	}

	public int getPointsObtained() {
		return pointsObtained;
	}

	public void setPointsObtained(int pointsObtained) {
		this.pointsObtained = pointsObtained;
	}

	public int getOperationsPerformed() {
		return operationsPerformed;
	}

	public void setOperationsPerformed(int operationsPerformed) {
		this.operationsPerformed = operationsPerformed;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	@Id
    @Column(nullable = false, unique=true)
//    @Email(message = "Please provide a valid email address")
//    @NotBlank
    private String email;

    @Column(nullable = false, unique = true)
//    @Size(min=8, max=8)
//    @LettersAndNumbersOnlyAdmits
//    @NotBlank
    private String walletAddress;

    @Column(nullable = false)
//    @Size(min=3, max=30)
//    @LettersOnlyAdmits
    private String name;

    @Column(nullable = false)
//    @Size(min=3, max=30)
//    @LettersOnlyAdmits
    private String surname;

    @Column(nullable = false)
//    @Size(min=10, max=30)
//    @LettersAndNumbersOnlyAdmits
    private String address;

    @Column(nullable = false)
//    @SpecialCharactersOnlyAdmits
//    @PasswordSize
    private String password;

    @Column(nullable = false)
//    @Size(min=22, max=22)
//    @NumbersOnlyAdmits
    private String cvu;

    @Column(nullable = false)
 //   @NotNull
    private int pointsObtained = 0;

    @Column(nullable = false)
//    @NotNull
    private int operationsPerformed = 0;

    @ManyToMany(fetch= FetchType.EAGER)
    @JoinColumn(name = "id_role")
    private List<Role> roles;

    public User(String email, String walletAddress, String name, String surname, String address, String password, String cvu,Role ... roles) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.password = password;
        this.cvu = cvu;
        this.walletAddress = walletAddress;
		this.roles = Arrays.asList(roles);
    }

    public String getId() {
        return this.email;
    }

    public void discountPoints(int points) {
        pointsObtained = pointsObtained - Math.abs(points);
    }
    public void addPoints(int points) {
        pointsObtained = pointsObtained + Math.abs(points);
    }
}