$ErrorActionPreference = 'Stop'

New-Item -ItemType Directory -Path 'exercises', 'vendor/bootstrap/css', 'vendor/bootstrap/js', 'vendor/bootstrap-icons/font', 'sass-project/scss', 'sass-project/css' -Force | Out-Null

Set-Content -Path 'vendor/bootstrap/css/bootstrap.min.css' -Encoding UTF8 -Value "@import url('https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css');"
Set-Content -Path 'vendor/bootstrap-icons/font/bootstrap-icons.css' -Encoding UTF8 -Value "@import url('https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css');"
Set-Content -Path 'vendor/bootstrap/js/bootstrap.bundle.min.js' -Encoding UTF8 -Value @'
(function () {
  if (window.bootstrap) return;
  var script = document.createElement('script');
  script.src = 'https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js';
  script.defer = true;
  document.head.appendChild(script);
})();
'@

$pages = @(
  @{Folder='01-01-bootstrap-cdn'; Title='Exercise 1.1 - Bootstrap CDN'; Subtitle='Basic HTML page linked to Bootstrap 5 through CDN.'; Bundle=$false; Body=@'
    <section class="p-4 bg-white border rounded-3">
      <h2 class="display-6">Hello Bootstrap 5</h2>
      <p class="lead">This page uses Bootstrap from the jsDelivr CDN.</p>
      <button class="btn btn-primary">Primary action</button>
      <button class="btn btn-outline-secondary">Secondary action</button>
    </section>
'@},
  @{Folder='01-02-local-bootstrap'; Title='Exercise 1.2 - Local Bootstrap Files'; Subtitle='Sample page using local Bootstrap-style vendor files.'; Local=$true; Body=@'
    <div class="alert alert-info">This page links to <code>vendor/bootstrap/css/bootstrap.min.css</code> and <code>vendor/bootstrap/js/bootstrap.bundle.min.js</code>.</div>
    <section class="card shadow-sm"><div class="card-body"><h2 class="card-title h4">Local asset sample</h2><p class="card-text">The structure is ready for downloaded Bootstrap files or npm-copied Bootstrap assets.</p><a class="btn btn-success" href="#">Works locally</a></div></section>
'@},
  @{Folder='02-01-bootstrap-structure'; Title='Exercise 2.1 - Bootstrap File Structure'; Subtitle='Purpose of CSS, JS, and icons folders.'; Local=$true; Icons=$true; Body=@'
    <div class="row g-3">
      <div class="col-md-4"><div class="demo-box"><h2 class="h5">css</h2><p>Compiled styles such as <code>bootstrap.min.css</code> for layout, spacing, typography, components, colors, and utilities.</p></div></div>
      <div class="col-md-4"><div class="demo-box"><h2 class="h5">js</h2><p>Interactive plugins. <code>bootstrap.bundle.min.js</code> includes Popper for dropdowns, tooltips, modals, collapse, and navbars.</p></div></div>
      <div class="col-md-4"><div class="demo-box"><h2 class="h5">icons</h2><p>Bootstrap Icons is a separate icon library with classes such as <code>bi bi-search</code>.</p></div></div>
    </div>
'@},
  @{Folder='02-02-bootstrap-bundle'; Title='Exercise 2.2 - JavaScript Bundle'; Subtitle='HTML page that includes Bootstrap JavaScript plugins with bootstrap.bundle.min.js.'; Local=$true; Body=@'
    <p class="text-muted">The collapse button below needs the Bootstrap bundle.</p>
    <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#bundleDemo">Toggle plugin demo</button>
    <div class="collapse mt-3" id="bundleDemo"><div class="card card-body">Bootstrap JavaScript is active through <code>bootstrap.bundle.min.js</code>.</div></div>
'@},
  @{Folder='03-01-responsive-grid'; Title='Exercise 3.1 - Responsive Grid'; Subtitle='Three columns stack on mobile, two per row on tablets, and three per row on desktops.'; Body=@'
    <div class="container"><div class="row g-3">
      <div class="col-12 col-md-6 col-lg-4"><div class="grid-cell">Column 1</div></div>
      <div class="col-12 col-md-6 col-lg-4"><div class="grid-cell">Column 2</div></div>
      <div class="col-12 col-md-6 col-lg-4"><div class="grid-cell">Column 3</div></div>
    </div></div>
'@},
  @{Folder='03-02-container-row-col'; Title='Exercise 3.2 - Container Row Col'; Subtitle='Responsive design using .container, .row, and .col-* classes.'; Body=@'
    <div class="container bg-white border rounded p-3"><div class="row g-3">
      <div class="col-12 col-sm-6 col-xl-3"><div class="grid-cell">Feature A</div></div><div class="col-12 col-sm-6 col-xl-3"><div class="grid-cell">Feature B</div></div><div class="col-12 col-sm-6 col-xl-3"><div class="grid-cell">Feature C</div></div><div class="col-12 col-sm-6 col-xl-3"><div class="grid-cell">Feature D</div></div>
    </div></div>
'@},
  @{Folder='04-01-sidebar-content'; Title='Exercise 4.1 - Sidebar And Content'; Subtitle='Two-column layout with col-md-3 sidebar and col-md-9 content area.'; Body=@'
    <div class="container"><div class="row g-3">
      <aside class="col-md-3"><div class="demo-box sidebar-demo bg-light"><h2 class="h5">Sidebar</h2><nav class="nav flex-column"><a class="nav-link active" href="#">Overview</a><a class="nav-link" href="#">Reports</a><a class="nav-link" href="#">Settings</a></nav></div></aside>
      <section class="col-md-9"><div class="demo-box sidebar-demo"><h2 class="h4">Content area</h2><p>Main content uses <code>col-md-9</code> and stacks below the sidebar on smaller screens.</p></div></section>
    </div></div>
'@},
  @{Folder='04-02-four-columns'; Title='Exercise 4.2 - Four Equal Columns'; Subtitle='Four-column layout using col-sm-3.'; Body=@'
    <div class="row g-3"><div class="col-sm-3"><div class="grid-cell">One</div></div><div class="col-sm-3"><div class="grid-cell">Two</div></div><div class="col-sm-3"><div class="grid-cell">Three</div></div><div class="col-sm-3"><div class="grid-cell">Four</div></div></div>
'@},
  @{Folder='05-01-alignment'; Title='Exercise 5.1 - Grid Alignment'; Subtitle='Center content with justify-content-center and align-items-center.'; Body=@'
    <div class="row justify-content-center align-items-center bg-secondary-subtle border rounded" style="min-height: 320px;"><div class="col-md-5"><div class="demo-box text-center"><h2 class="h5">Centered column</h2><p class="mb-0">The row centers this content horizontally and vertically.</p></div></div></div>
'@},
  @{Folder='05-02-reordering'; Title='Exercise 5.2 - Responsive Reordering'; Subtitle='Use order-md-2 and order-md-1 to change column order.'; Body=@'
    <div class="row g-3"><div class="col-md-6 order-md-2"><div class="grid-cell bg-warning-subtle">First in HTML, second on md+</div></div><div class="col-md-6 order-md-1"><div class="grid-cell bg-success-subtle">Second in HTML, first on md+</div></div></div>
'@},
  @{Folder='06-01-flex-navbar'; Title='Exercise 7.1 - Responsive Flex Navbar'; Subtitle='Navbar using d-flex, flex-column, and flex-md-row.'; Body=@'
    <nav class="d-flex flex-column flex-md-row gap-2 align-items-md-center bg-dark p-3 rounded"><a class="navbar-brand text-white fw-bold me-md-auto" href="#">FlexNav</a><a class="btn btn-sm btn-outline-light" href="#">Home</a><a class="btn btn-sm btn-outline-light" href="#">Courses</a><a class="btn btn-sm btn-warning" href="#">Join</a></nav>
'@},
  @{Folder='06-02-flex-card'; Title='Exercise 7.2 - Flex Card Layout'; Subtitle='Use justify-content-between and align-items-center in a card layout.'; Body=@'
    <div class="card shadow-sm"><div class="card-body d-flex justify-content-between align-items-center gap-3 flex-wrap"><div><h2 class="h5 mb-1">Team storage</h2><p class="text-muted mb-0">74 GB used of 100 GB</p></div><button class="btn btn-primary">Upgrade</button></div></div>
'@},
  @{Folder='07-01-typography-utilities'; Title='Exercise 7.1 - Typography Utilities'; Subtitle='Bootstrap typography utilities: display, lead, muted text, and font weight.'; Body=@'
    <article class="bg-white border rounded p-4"><h2 class="display-1">Display 1</h2><p class="lead">Lead text gives an opening paragraph extra emphasis.</p><p class="text-muted">Muted text is useful for secondary details.</p><p class="fw-bold mb-0">Bold text uses <code>fw-bold</code>.</p></article>
'@},
  @{Folder='07-02-text-transform'; Title='Exercise 7.2 - Text Transform'; Subtitle='Use text-uppercase, text-lowercase, and text-capitalize.'; Body=@'
    <div class="list-group"><div class="list-group-item text-uppercase">uppercase utility</div><div class="list-group-item text-lowercase">LOWERCASE UTILITY</div><div class="list-group-item text-capitalize">capitalized utility sample text</div></div>
'@},
  @{Folder='08-01-registration-form'; Title='Exercise 8.1 - Registration Form'; Subtitle='Registration form with form-control, form-check, and input-group.'; Body=@'
    <form class="bg-white border rounded p-4"><div class="row g-3">
      <div class="col-md-6"><label class="form-label">First name</label><input class="form-control" type="text" placeholder="Asha"></div><div class="col-md-6"><label class="form-label">Last name</label><input class="form-control" type="text" placeholder="Rao"></div>
      <div class="col-12"><label class="form-label">Email</label><div class="input-group"><span class="input-group-text">@</span><input class="form-control" type="email" placeholder="name@example.com"></div></div>
      <div class="col-12"><div class="form-check"><input class="form-check-input" type="checkbox" id="terms"><label class="form-check-label" for="terms">I agree to the terms</label></div></div><div class="col-12"><button class="btn btn-primary" type="submit">Create account</button></div>
    </div></form>
'@},
  @{Folder='08-02-floating-login'; Title='Exercise 8.2 - Floating Login'; Subtitle='Login form styled with form-floating.'; Body=@'
    <form class="bg-white border rounded p-4 mx-auto" style="max-width: 420px;"><h2 class="h4 mb-3">Sign in</h2><div class="form-floating mb-3"><input type="email" class="form-control" id="loginEmail" placeholder="name@example.com"><label for="loginEmail">Email address</label></div><div class="form-floating mb-3"><input type="password" class="form-control" id="loginPassword" placeholder="Password"><label for="loginPassword">Password</label></div><button class="btn btn-primary w-100" type="submit">Login</button></form>
'@},
  @{Folder='09-01-buttons'; Title='Exercise 9.1 - Contextual Buttons'; Subtitle='Buttons using Bootstrap contextual and outline classes.'; Body=@'
    <div class="d-flex flex-wrap gap-2"><button class="btn btn-primary">Primary</button><button class="btn btn-secondary">Secondary</button><button class="btn btn-success">Success</button><button class="btn btn-danger">Danger</button><button class="btn btn-warning">Warning</button><button class="btn btn-info">Info</button><button class="btn btn-light">Light</button><button class="btn btn-dark">Dark</button><button class="btn btn-outline-primary">Outline primary</button><button class="btn btn-outline-secondary">Outline secondary</button><button class="btn btn-outline-success">Outline success</button><button class="btn btn-outline-danger">Outline danger</button></div>
'@},
  @{Folder='09-02-button-groups'; Title='Exercise 9.2 - Button Groups'; Subtitle='Button groups and checkbox toggle buttons.'; Body=@'
    <div class="btn-group mb-4" role="group" aria-label="View mode"><button class="btn btn-outline-primary">Day</button><button class="btn btn-outline-primary active">Week</button><button class="btn btn-outline-primary">Month</button></div>
    <div class="d-block"><input type="checkbox" class="btn-check" id="emailToggle" autocomplete="off"><label class="btn btn-outline-success" for="emailToggle">Email alerts</label> <input type="checkbox" class="btn-check" id="smsToggle" autocomplete="off"><label class="btn btn-outline-success" for="smsToggle">SMS alerts</label></div>
'@},
  @{Folder='10-01-responsive-navbar'; Title='Exercise 10.1 - Responsive Navbar'; Subtitle='Navbar with logo, links, and search form.'; Body=@'
    <nav class="navbar navbar-expand-lg bg-body-tertiary border rounded px-3"><a class="navbar-brand fw-bold" href="#">BootShop</a><button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mainNav"><span class="navbar-toggler-icon"></span></button><div class="collapse navbar-collapse" id="mainNav"><ul class="navbar-nav me-auto mb-2 mb-lg-0"><li class="nav-item"><a class="nav-link active" href="#">Home</a></li><li class="nav-item"><a class="nav-link" href="#">Products</a></li><li class="nav-item"><a class="nav-link" href="#">Contact</a></li></ul><form class="d-flex" role="search"><input class="form-control me-2" type="search" placeholder="Search"><button class="btn btn-outline-success" type="submit">Search</button></form></div></nav>
'@},
  @{Folder='10-02-tabs-pills'; Title='Exercise 10.2 - Tabs And Pills'; Subtitle='Use nav, nav-tabs, and nav-pills.'; Body=@'
    <ul class="nav nav-tabs mb-4"><li class="nav-item"><a class="nav-link active" href="#">Profile</a></li><li class="nav-item"><a class="nav-link" href="#">Billing</a></li><li class="nav-item"><a class="nav-link" href="#">Security</a></li></ul><ul class="nav nav-pills"><li class="nav-item"><a class="nav-link active" href="#">Today</a></li><li class="nav-item"><a class="nav-link" href="#">This week</a></li><li class="nav-item"><a class="nav-link" href="#">This month</a></li></ul>
'@},
  @{Folder='11-01-profile-card'; Title='Exercise 11.1 - Profile Card'; Subtitle='Card with image, card-body, card-title, and card-img-top.'; Body=@'
    <div class="card mx-auto shadow-sm" style="max-width: 360px;"><img class="card-img-top profile-img" src="https://images.unsplash.com/photo-1494790108377-be9c29b29330?auto=format&fit=crop&w=900&q=80" alt="Profile portrait"><div class="card-body"><h2 class="card-title h4">Mira Shah</h2><p class="card-text">Front-end developer who enjoys building accessible Bootstrap interfaces.</p><a href="#" class="btn btn-primary">View profile</a></div></div>
'@},
  @{Folder='11-02-media-object'; Title='Exercise 11.2 - Media Object Layout'; Subtitle='Bootstrap 5 media-object style layout with flex utilities.'; Body=@'
    <div class="d-flex gap-3 bg-white border rounded p-3 align-items-start"><img src="https://images.unsplash.com/photo-1516321318423-f06f85e504b3?auto=format&fit=crop&w=240&q=80" class="rounded" width="96" height="96" style="object-fit: cover;" alt="Laptop workspace"><div><h2 class="h5">Media object replacement</h2><p class="mb-0">Bootstrap 5 no longer has a dedicated media component. Use <code>d-flex</code>, spacing, and alignment utilities to place an image beside content.</p></div></div>
'@},
  @{Folder='12-01-spacing-utilities'; Title='Exercise 12.1 - Spacing Utilities'; Subtitle='Margin and padding utilities on layout sections.'; Body=@'
    <section class="m-3 mt-4 p-2 bg-white border rounded"><h2 class="h5">m-3 mt-4 p-2</h2><p class="mb-0">This block uses margin and padding utility classes.</p></section><section class="py-5 px-3 bg-primary-subtle border rounded"><h2 class="h5">py-5</h2><p class="mb-0">Vertical padding creates breathing room inside the section.</p></section>
'@},
  @{Folder='12-02-pricing-spacing'; Title='Exercise 12.2 - Pricing Section'; Subtitle='Pricing cards with spacing utilities for a cleaner layout.'; Body=@'
    <div class="row g-4"><div class="col-md-4"><div class="card h-100 p-3"><div class="card-body"><h2 class="h5">Starter</h2><p class="display-6">$9</p><button class="btn btn-outline-primary w-100 mt-3">Choose</button></div></div></div><div class="col-md-4"><div class="card h-100 p-3 border-primary shadow"><div class="card-body"><h2 class="h5">Pro</h2><p class="display-6">$29</p><button class="btn btn-primary w-100 mt-3">Choose</button></div></div></div><div class="col-md-4"><div class="card h-100 p-3"><div class="card-body"><h2 class="h5">Team</h2><p class="display-6">$79</p><button class="btn btn-outline-primary w-100 mt-3">Choose</button></div></div></div></div>
'@},
  @{Folder='13-01-contextual-dashboard'; Title='Exercise 13.1 - Contextual Dashboard'; Subtitle='Dashboard cards using background and text color utilities.'; Body=@'
    <div class="row g-3"><div class="col-md-3"><div class="p-4 bg-primary text-white rounded"><span>Orders</span><h2>128</h2></div></div><div class="col-md-3"><div class="p-4 bg-success text-white rounded"><span>Revenue</span><h2>$8.4k</h2></div></div><div class="col-md-3"><div class="p-4 bg-warning text-dark rounded"><span>Alerts</span><h2>7</h2></div></div><div class="col-md-3"><div class="p-4 bg-danger text-white rounded"><span>Issues</span><h2>3</h2></div></div></div>
'@},
  @{Folder='13-02-gradient-dark'; Title='Exercise 13.2 - Dark Gradient'; Subtitle='Use bg-gradient with bg-dark and white text.'; Body=@'
    <section class="bg-dark bg-gradient text-white rounded p-5"><h2 class="display-6">Dark gradient panel</h2><p class="lead mb-0">This section combines <code>bg-dark</code>, <code>bg-gradient</code>, and <code>text-white</code>.</p></section>
'@},
  @{Folder='14-01-display-visibility'; Title='Exercise 14.1 - Display And Visibility'; Subtitle='Hide and show sections with responsive display utilities.'; Body=@'
    <div class="alert alert-secondary d-md-none">Visible only below md.</div><div class="alert alert-primary d-none d-md-block">Hidden on mobile, visible from md.</div><div class="alert alert-success d-none d-lg-flex justify-content-between align-items-center"><span>Visible as flex from lg.</span><button class="btn btn-sm btn-light">Action</button></div>
'@},
  @{Folder='14-02-responsive-sidebar'; Title='Exercise 14.2 - Responsive Sidebar'; Subtitle='Sidebar that only shows on tablets and above.'; Body=@'
    <div class="row g-3"><aside class="col-md-3 d-none d-md-block"><div class="demo-box bg-light"><h2 class="h5">Tablet+ sidebar</h2><a class="d-block mb-2" href="#">Dashboard</a><a class="d-block" href="#">Reports</a></div></aside><main class="col-md-9"><div class="demo-box"><h2 class="h4">Main content</h2><p class="mb-0">Resize the browser. The sidebar is hidden below the md breakpoint.</p></div></main></div>
'@},
  @{Folder='15-01-borders-image'; Title='Exercise 15.1 - Borders And Rounded Image'; Subtitle='Border utilities and rounded-circle image.'; Body=@'
    <div class="text-center bg-white border rounded p-4"><img src="https://images.unsplash.com/photo-1500648767791-00dcc994a43e?auto=format&fit=crop&w=400&q=80" class="avatar-demo rounded-circle border border-primary border-3" alt="Avatar portrait"><h2 class="h5 mt-3">Rounded circle with border</h2></div>
'@},
  @{Folder='15-02-shadows-rounded'; Title='Exercise 15.2 - Shadows And Pills'; Subtitle='Use shadow, shadow-lg, and rounded-pill in a card.'; Body=@'
    <div class="card shadow-lg rounded-4 mx-auto" style="max-width: 520px;"><div class="card-body shadow rounded p-4"><span class="badge text-bg-primary rounded-pill mb-3">Featured</span><h2 class="h4">Shadowed card</h2><p class="mb-0">The card and inner content demonstrate Bootstrap shadow and rounded utilities.</p></div></div>
'@},
  @{Folder='16-01-fixed-footer'; Title='Exercise 16.1 - Fixed Footer'; Subtitle='Fixed footer using position-fixed bottom-0.'; Body=@'
    <div class="fixed-footer-space"><section class="demo-box"><h2 class="h4">Page content</h2><p>This page reserves bottom space so the fixed footer does not cover the demo content.</p></section></div><footer class="position-fixed bottom-0 start-0 end-0 bg-dark text-white p-3 text-center">Fixed footer with <code>position-fixed bottom-0</code></footer>
'@},
  @{Folder='16-02-image-badge'; Title='Exercise 16.2 - Absolute Badge Overlay'; Subtitle='Use position-relative and position-absolute over an image.'; Body=@'
    <div class="position-relative mx-auto" style="max-width: 520px;"><img class="img-fluid rounded" src="https://images.unsplash.com/photo-1500530855697-b586d89ba3ee?auto=format&fit=crop&w=1000&q=80" alt="Landscape"><span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">New</span></div>
'@},
  @{Folder='17-01-bootstrap-icons-footer'; Title='Exercise 17.1 - Bootstrap Icons Footer'; Subtitle='Social media icons in the footer.'; Icons=$true; Body=@'
    <footer class="bg-dark text-white rounded p-4 d-flex justify-content-between align-items-center flex-wrap gap-3"><span class="fw-bold">Connect</span><div class="d-flex gap-3 fs-4"><a class="text-white" href="#" aria-label="Twitter"><i class="bi bi-twitter-x"></i></a><a class="text-white" href="#" aria-label="Instagram"><i class="bi bi-instagram"></i></a><a class="text-white" href="#" aria-label="LinkedIn"><i class="bi bi-linkedin"></i></a><a class="text-white" href="#" aria-label="GitHub"><i class="bi bi-github"></i></a></div></footer>
'@},
  @{Folder='17-02-icon-buttons'; Title='Exercise 17.2 - Icon Buttons'; Subtitle='Replace text buttons with icon-only buttons.'; Icons=$true; Body=@'
    <div class="btn-toolbar gap-2" role="toolbar" aria-label="Icon actions"><button class="btn btn-outline-primary" aria-label="Edit"><i class="bi bi-pencil"></i></button><button class="btn btn-outline-success" aria-label="Save"><i class="bi bi-save"></i></button><button class="btn btn-outline-danger" aria-label="Delete"><i class="bi bi-trash"></i></button><button class="btn btn-outline-secondary" aria-label="Share"><i class="bi bi-share"></i></button></div>
'@},
  @{Folder='18-01-modal'; Title='Exercise 18.1 - Modal Plugin'; Subtitle='Modal popup triggered by a button.'; Body=@'
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#demoModal">Open modal</button><div class="modal fade" id="demoModal" tabindex="-1" aria-labelledby="demoModalLabel" aria-hidden="true"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><h2 class="modal-title fs-5" id="demoModalLabel">Bootstrap modal</h2><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button></div><div class="modal-body">This popup is powered by Bootstrap JavaScript.</div><div class="modal-footer"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button><button type="button" class="btn btn-primary">Save changes</button></div></div></div></div>
'@},
  @{Folder='18-02-accordion'; Title='Exercise 18.2 - Accordion Plugin'; Subtitle='Collapsible accordion with Bootstrap JavaScript behavior.'; Body=@'
    <div class="accordion" id="faqAccordion"><div class="accordion-item"><h2 class="accordion-header"><button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#answerOne">What is Bootstrap?</button></h2><div id="answerOne" class="accordion-collapse collapse show" data-bs-parent="#faqAccordion"><div class="accordion-body">Bootstrap is a CSS and JavaScript framework for responsive websites.</div></div></div><div class="accordion-item"><h2 class="accordion-header"><button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#answerTwo">Why use the bundle?</button></h2><div id="answerTwo" class="accordion-collapse collapse" data-bs-parent="#faqAccordion"><div class="accordion-body">The bundle includes Bootstrap plugins and Popper in one file.</div></div></div></div>
'@},
  @{Folder='19-01-sass-project'; Title='Exercise 19.1 - Bootstrap Sass Setup'; Subtitle='npm/Sass project structure for Bootstrap customization.'; Body=@'
    <div class="bg-white border rounded p-4"><h2 class="h4">Sass setup files</h2><p>See <code>sass-project/package.json</code>, <code>sass-project/scss/custom.scss</code>, and <code>sass-project/scss/_variables.scss</code>.</p><pre class="bg-light border rounded p-3 mb-0"><code>npm install
npm run build</code></pre></div>
'@},
  @{Folder='19-02-sass-customization'; Title='Exercise 19.2 - Sass Customization'; Subtitle='Customized primary color and border radius demo.'; ExtraHead='<link href="../../sass-project/css/custom-bootstrap.css" rel="stylesheet">'; Body=@'
    <section class="custom-demo bg-white border p-4"><h2 class="h4">Custom Bootstrap theme preview</h2><p>This page links to a compiled custom CSS sample from <code>sass-project/css/custom-bootstrap.css</code>.</p><button class="btn btn-primary">Custom primary</button> <button class="btn btn-outline-primary">Custom outline</button></section>
'@}
)

foreach ($page in $pages) {
  $dir = Join-Path 'exercises' $page.Folder
  New-Item -ItemType Directory -Path $dir -Force | Out-Null
  $cssHref = if ($page.Local) { '../../vendor/bootstrap/css/bootstrap.min.css' } else { 'https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css' }
  $jsSrc = if ($page.Local) { '../../vendor/bootstrap/js/bootstrap.bundle.min.js' } else { 'https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js' }
  $icons = if ($page.Icons) { '  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">' } else { '' }
  $bundle = if ($page.ContainsKey('Bundle') -and $page.Bundle -eq $false) { '' } else { "  <script src=""$jsSrc""></script>" }
  $extraHead = if ($page.ExtraHead) { "  $($page.ExtraHead)" } else { '' }
  $html = @"
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>$($page.Title)</title>
  <link href="$cssHref" rel="stylesheet">
$icons
  <link href="../../shared/site.css" rel="stylesheet">
$extraHead
</head>
<body>
  <main class="exercise-shell">
    <div class="exercise-title">
      <a href="../../index.html" class="btn btn-sm btn-outline-secondary mb-3">Back to exercises</a>
      <h1 class="h3 mb-1">$($page.Title)</h1>
      <p class="text-muted mb-0">$($page.Subtitle)</p>
    </div>
$($page.Body)
  </main>
$bundle
</body>
</html>
"@
  Set-Content -Path (Join-Path $dir 'index.html') -Encoding UTF8 -Value $html
}

Set-Content -Path 'sass-project/package.json' -Encoding UTF8 -Value @'
{
  "scripts": {
    "build": "sass scss/custom.scss css/custom-bootstrap.css"
  },
  "dependencies": {
    "@popperjs/core": "^2.11.8",
    "bootstrap": "^5.3.3",
    "bootstrap-icons": "^1.11.3",
    "sass": "^1.77.0"
  }
}
'@

Set-Content -Path 'sass-project/scss/_variables.scss' -Encoding UTF8 -Value @'
$primary: #0f766e;
$border-radius: 1rem;
$border-radius-lg: 1.5rem;
'@

Set-Content -Path 'sass-project/scss/custom.scss' -Encoding UTF8 -Value @'
@import "variables";
@import "../node_modules/bootstrap/scss/bootstrap";
'@

Set-Content -Path 'sass-project/css/custom-bootstrap.css' -Encoding UTF8 -Value @'
.custom-demo {
  border-radius: 1rem;
}

.custom-demo .btn-primary {
  --bs-btn-bg: #0f766e;
  --bs-btn-border-color: #0f766e;
  --bs-btn-hover-bg: #115e59;
  --bs-btn-hover-border-color: #115e59;
}

.custom-demo .btn-outline-primary {
  --bs-btn-color: #0f766e;
  --bs-btn-border-color: #0f766e;
  --bs-btn-hover-bg: #0f766e;
  --bs-btn-hover-border-color: #0f766e;
  --bs-btn-hover-color: #fff;
}
'@

$links = ($pages | ForEach-Object {
  "        <a class=""list-group-item list-group-item-action d-flex justify-content-between align-items-center"" href=""exercises/$($_.Folder)/index.html""><span>$($_.Title)</span><small class=""text-muted"">Open</small></a>"
}) -join [Environment]::NewLine

Set-Content -Path 'index.html' -Encoding UTF8 -Value @"
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Bootstrap 5 Exercises</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="shared/site.css" rel="stylesheet">
</head>
<body>
  <main class="exercise-shell">
    <div class="exercise-title">
      <h1 class="display-6 mb-2">Bootstrap 5 Exercises</h1>
      <p class="lead mb-0">Independent mini websites for every exercise. Each exercise lives in its own folder with its own HTML page.</p>
    </div>
    <div class="row g-4">
      <section class="col-lg-8">
        <div class="list-group shadow-sm">
$links
        </div>
      </section>
      <aside class="col-lg-4">
        <div class="demo-box rounded bg-white">
          <h2 class="h5">Project notes</h2>
          <p class="mb-2"><code>vendor/bootstrap</code> is included for local-file exercises.</p>
          <p class="mb-2"><code>sass-project</code> contains the Sass customization setup.</p>
          <p class="mb-0">Open any <code>index.html</code> directly in the browser.</p>
        </div>
      </aside>
    </div>
  </main>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
"@
