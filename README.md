# Tenant Management System

An Android app for landlords to record tenants, see total rent, and call tenants.

## Download
Latest APK: see **Releases** on the right of this page.

## Features
- Register and log in
- Dashboard with number of tenants and total rent
- Add tenants and view all tenants (saved with Room)
- Call a tenant, options menu and navigation drawer

## Architecture
- `ui/` — Activities, Fragments and TenantViewModel (UI layer)
- `data/` — Tenant, TenantDao, TenantDatabase, TenantRepository (data layer)

`Screens -> TenantViewModel (LiveData) -> TenantRepository -> Room`

## Team

| Stage | Member                 | Admission No. | Pull request |
|---|------------------------|---------------|-|
| 1 Lead | Lavenda Grace          | 190386        | 
| 2 ViewModel | Aya Tia Rita           | 167076        | |
| 3 Room | Rosemary Wanjiru       | 190152        | |
| 4 Screens | Michael Opondo Clinton | 169318        | |
| 5 Data integration | Nicole Nyakommita      | 189546        | ( |
| 6 Release | Lavenda Grace          | 190386        | |
